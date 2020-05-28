package net.ziyoung.ccool;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.compiler.Compiler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Filename is required.");
            return;
        }

        String inputFile = args[0];
        Compiler compiler = new Compiler(inputFile);
        CompilationUnit compilationUnit = compiler.compile();
        System.out.printf("compilationUnit %s\n", compilationUnit);
        // define phase.
//        ParseTreeWalker walker = new ParseTreeWalker();
//        DefinePhase definePhase = new DefinePhase(compiler);
//        walker.walk(definePhase, tree);

        // checker phase.
//        ParseTreeProperty<Scope> scopes = definePhase.getScopes();
//        GlobalScope globalScope = definePhase.getGlobalScope();
//        CheckPhase checkPhase = new CheckPhase(compiler, scopes, globalScope);
//        walker.walk(checkPhase, tree);
//        if (!compiler.isPassed()) {
//            compiler.report();
//            return;
//        }
        System.out.println("todo: start to generate class file.");

        // generate class file
    }
}
