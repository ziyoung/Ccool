package net.ziyoung.ccool;

import net.ziyoung.ccool.ast.GlobalScope;
import net.ziyoung.ccool.ast.Scope;
import net.ziyoung.ccool.compiler.Compiler;
import net.ziyoung.ccool.phase.CheckPhase;
import net.ziyoung.ccool.phase.DefinePhase;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Filename is required.");
            return;
        }

        String inputFile = args[0];
        Compiler compiler = new Compiler(inputFile);
        ParseTree tree = compiler.compile();
        if (compiler.isFailed()) {
            return;
        }

        // define phase.
        ParseTreeWalker walker = new ParseTreeWalker();
        DefinePhase definePhase = new DefinePhase(compiler);
        walker.walk(definePhase, tree);

        // checker phase.
        ParseTreeProperty<Scope> scopes = definePhase.getScopes();
        GlobalScope globalScope = definePhase.getGlobalScope();
        CheckPhase checkPhase = new CheckPhase(compiler, scopes, globalScope);
        walker.walk(checkPhase, tree);
        if (!compiler.isPassed()) {
            compiler.report();
            return;
        }
        System.out.println("todo: start to generate class file.");

        // generate class file
    }
}
