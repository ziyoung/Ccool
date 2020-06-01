package net.ziyoung.ccool;

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
        compiler.compile();
        if (!compiler.compileSuccess()) {
            compiler.report();
            return;
        }
        System.out.println("todo: start to generate class file.");

    }
}
