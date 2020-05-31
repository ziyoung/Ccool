package net.ziyoung.ccool.builtin;

import net.ziyoung.ccool.scope.FunctionScope;
import net.ziyoung.ccool.scope.Scope;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

public class Print extends FunctionScope {
    public Print(Type type, Token token, Scope enclosingScope) {
        super(type, token, enclosingScope);
    }
}
