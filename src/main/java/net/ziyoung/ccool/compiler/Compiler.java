package net.ziyoung.ccool.compiler;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.error.SemanticError;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.parser.CcoolLangParser;
import net.ziyoung.ccool.phase.AnalysePhase;
import net.ziyoung.ccool.phase.GeneratePhase;
import net.ziyoung.ccool.phase.PreAnalysePhase;
import org.objectweb.asm.ClassWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Compiler {
    private CcoolLangParser parser;
    private final String fileName;
    private CompilationUnit compilationUnit;
    private AnalysePhase analysePhase;

    public Compiler(String fileName) {
        this.fileName = fileName;
        SemanticErrors.startRecord();
    }

    public void compile() throws IOException {
        compilationUnit = parse();
        if (!parseSuccess()) {
            return;
        }
        preAnalyse();
        analyse();
    }

    public CompilationUnit parse() throws IOException {
        parser = new CcoolLangParser(fileName);
        return parser.parse();
    }

    public void preAnalyse() {
        // FIXME: It's hard to test.
        PreAnalysePhase preAnalysePhase = new PreAnalysePhase();
        preAnalysePhase.visitCompilationUnit(compilationUnit, null);
    }

    public void analyse() {
        analysePhase = new AnalysePhase();
        analysePhase.visitCompilationUnit(compilationUnit, null);
    }

    public void generate() throws IOException {
        ClassWriter classWriter = new ClassWriter(0);
        GeneratePhase generatePhase = new GeneratePhase();
        generatePhase.visitCompilationUnit(compilationUnit, classWriter);
        classWriter.visitEnd();

        String name = fileName.replace(".ccool", "") + ".class";
        System.out.printf("name is %s\n", name);
        OutputStream outputStream = new FileOutputStream(name);
        outputStream.write(classWriter.toByteArray());
        outputStream.close();
    }

    public void setCompilationUnit(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public boolean parseSuccess() {
        return parser.success();
    }

    public boolean compileSuccess() {
        return SemanticErrors.success();
    }

    public List<SemanticError> errors() {
        return SemanticErrors.getErrors();
    }

    public void report() {
        SemanticErrors.report();
    }

    public CompilationUnit getCompilationUnit() {
        return compilationUnit;
    }

    public AnalysePhase getAnalysePhase() {
        return analysePhase;
    }
}
