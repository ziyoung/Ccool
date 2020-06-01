package net.ziyoung.ccool.type;

import net.ziyoung.ccool.context.Context;
import org.antlr.v4.runtime.Token;

public class TypeName extends Type {
    private final Token token;

    public TypeName(Token token) {
        this.token = token;
    }

    @Override
    public String getName() {
        return token.getText();
    }

    public Token getToken() {
        return token;
    }

    public Type resolve(Context context) {
        return context.resolveType(getName());
    }
}
