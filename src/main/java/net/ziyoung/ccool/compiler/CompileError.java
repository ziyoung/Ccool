package net.ziyoung.ccool.compiler;

import org.antlr.v4.runtime.Token;

final class CompileError {
    Token token;
    String msg;

    public CompileError(Token token, String msg) {
        this.token = token;
        this.msg = msg;
    }

    @Override
    public String toString() {
        if (token == null) {
            return msg;
        }
        return String.format("line %d: %d %s", token.getLine(), token.getCharPositionInLine(), msg);
    }
}
