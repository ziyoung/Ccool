package net.ziyoung.ccool.error;

import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SemanticErrors {
    private static List<SemanticError> errors = Collections.emptyList();

    public static void startRecord() {
        errors = new ArrayList<>();
    }

    public static void report() {
        for (SemanticError err : errors) {
            System.err.println(err.toString());
        }
    }

    public static List<SemanticError> getErrors() {
        return errors;
    }

    public static boolean success() {
        return errors.size() == 0;
    }

    public static void error(Token token, String msg) {
        errors.add(new SemanticError(token, msg));
    }

    public static void errorUndefinedType(Token token) {
        error(token, String.format("type %s is not defined", token.getText()));
    }

    public static void errorUndefinedVariable(Token token) {
        error(token, String.format("variable %s is not defined", token.getText()));
    }

    public static void errorUnmatchedType(Token token, Type type, Type type1) {
        error(token, String.format("type doesn't match. Expected %s but got %s", type.getName(), type1.getName()));
    }

    public static void errorUndefinedMethod(Token token) {
        error(token, String.format("method %s is not defined", token.getText()));
    }

    public static void errorReDefine(Token token, String prefix) {
        error(token, String.format("%s %s has been defined", prefix, token.getText()));
    }
}
