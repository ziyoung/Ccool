package net.ziyoung.ccool;

import net.ziyoung.ccool.antlr.CcoolBaseListener;
import net.ziyoung.ccool.antlr.CcoolLexer;
import net.ziyoung.ccool.antlr.CcoolParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Compiler {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Filename is required.");
            return;
        }
        String inputFile = args[0];
        CharStream charStream = CharStreams.fromFileName(inputFile);
        CcoolLexer lexer = new CcoolLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CcoolParser parser = new CcoolParser(tokenStream);

        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();

        CcoolBaseListener listener = new CcoolBaseListener();
        walker.walk(listener, tree);
    }
}
