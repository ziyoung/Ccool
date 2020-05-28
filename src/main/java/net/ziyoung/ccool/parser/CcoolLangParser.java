package net.ziyoung.ccool.parser;

import net.ziyoung.ccool.antlr.CcoolLexer;
import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.ast.CompilationUnit;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class CcoolLangParser {
    private final String fileName;
    private ParseErrorListener errorListener;

    public CcoolLangParser(String fileName) {
        this.fileName = fileName;
    }

    public CompilationUnit parse() throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileName);
        CcoolLexer lexer = new CcoolLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CcoolParser parser = new CcoolParser(tokenStream);
        errorListener = new ParseErrorListener();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.compilationUnit();
        return (CompilationUnit) tree.accept(new AstBuilder());
    }

    public boolean isSuccess() {
        return !errorListener.isFailed();
    }
}
