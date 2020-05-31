package net.ziyoung.ccool.type;

import org.antlr.v4.runtime.Token;

public class TypeName extends Type {
    private final Token token;

    public TypeName(Token token) {
        this.token = token;
    }

    public String getName() {
        return token.getText();
    }
}
