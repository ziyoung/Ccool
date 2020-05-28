package net.ziyoung.ccool.compiler;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.parser.CcoolLangParser;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private CcoolLangParser parser;
    private final List<CompileError> errors = new ArrayList<>();
    private final String fileName;

    public Compiler(String fileName) {
        this.fileName = fileName;
    }

    public CompilationUnit compile() throws IOException {
        parser = new CcoolLangParser(fileName);
        return parser.parse();
    }

    public boolean parseSuccess() {
        return parser.isSuccess();
    }
    
    public boolean isPassed() {
        return errors.size() == 0;
    }

    public void report() {
        for (CompileError err : errors) {
            System.err.println(fileName + ": " + err.toString());
        }
    }

    public void error(Token token, String msg) {
        errors.add(new CompileError(token, msg));
    }
}
