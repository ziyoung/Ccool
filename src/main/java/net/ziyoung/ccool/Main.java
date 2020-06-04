package net.ziyoung.ccool;

import net.ziyoung.ccool.cmd.Cmd;
import net.ziyoung.ccool.compiler.Compiler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (!Cmd.checkArguments(args)) {
            return;
        }

        String inputFile = args[0];
        Compiler compiler = new Compiler(inputFile);
        compiler.compile();
        if (!compiler.compileSuccess()) {
            compiler.report();
            return;
        }
        System.out.println("==== start to generate class file ====");
        compiler.generate();
    }
}
