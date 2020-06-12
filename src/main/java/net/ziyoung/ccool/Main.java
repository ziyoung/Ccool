package net.ziyoung.ccool;

import net.ziyoung.ccool.cmd.Cmd;
import net.ziyoung.ccool.compiler.Compiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

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
        logger.info("==== start to generate class file ====");
        compiler.generate();
    }
}
