package net.ziyoung.ccool.compiler;

import org.antlr.v4.runtime.Token;

final class CompileError {
    Token name;
    String msg;

    public CompileError(Token name, String msg) {
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
