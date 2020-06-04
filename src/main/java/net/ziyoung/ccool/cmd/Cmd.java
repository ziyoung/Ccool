package net.ziyoung.ccool.cmd;

public class Cmd {
    public static boolean checkArguments(String[] args) {
        if (args.length != 1) {
            System.err.println("filename is required.");
            return false;
        }
        String fileName = args[0];
        if (!fileName.endsWith(".ccool")) {
            System.err.println("file should end width .ccool");
            return false;
        }
        return true;
    }
}
