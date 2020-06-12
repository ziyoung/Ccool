package net.ziyoung.ccool.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cmd {
    private static final Logger logger = LoggerFactory.getLogger(Cmd.class);

    public static boolean checkArguments(String[] args) {
        if (args.length != 1) {
            logger.error("filename is required");
            return false;
        }
        String fileName = args[0];
        if (!fileName.endsWith(".ccool")) {
            logger.error("file should end width .ccool");
            return false;
        }
        return true;
    }
}
