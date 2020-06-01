package net.ziyoung.ccool.error;

import org.antlr.v4.runtime.Token;

public class SemanticError {
    private final Token name;
    private final String msg;

    public SemanticError(Token name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    @Override
    public String toString() {
        if (name == null) {
            return msg;
        }
        return String.format("line %d: %d %s", name.getLine(), name.getCharPositionInLine(), msg);
    }

}
