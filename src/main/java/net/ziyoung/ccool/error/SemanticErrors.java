package net.ziyoung.ccool.error;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class SemanticErrors {
    private static final List<SemanticError> errors = new ArrayList<>();

    public static void report() {
        for (SemanticError err : errors) {
            System.err.println(err.toString());
        }
    }

    public static void error(Token token, String msg) {
        errors.add(new SemanticError(token, msg));
    }

    public static boolean success() {
        return errors.size() == 0;
    }
}
