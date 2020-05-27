package net.ziyoung.ccool.compiler;

import net.ziyoung.ccool.antlr.CcoolLexer;
import net.ziyoung.ccool.antlr.CcoolParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private final List<CompileError> errors = new ArrayList<>();
    private final String fileName;
    private ParseErrorListener errorListener;

    public Compiler(String fileName) {
        this.fileName = fileName;
    }

    public ParseTree compile() throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileName);
        CcoolLexer lexer = new CcoolLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CcoolParser parser = new CcoolParser(tokenStream);
        errorListener = new ParseErrorListener();
        parser.addErrorListener(errorListener);
        return parser.compilationUnit();
    }

    public boolean isFailed() {
        return errorListener.isFailed();
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
