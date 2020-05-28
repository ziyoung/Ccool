package net.ziyoung.ccool.builtin;

import net.ziyoung.ccool.ast.FunctionSymbolScope;
import net.ziyoung.ccool.ast.Scope;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

public class Print extends FunctionSymbolScope {
    public Print(Type type, Token token, Scope enclosingScope) {
        super(type, token, enclosingScope);
    }
}
