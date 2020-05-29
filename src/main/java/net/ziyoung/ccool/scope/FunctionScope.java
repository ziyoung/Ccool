package net.ziyoung.ccool.scope;

import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

import java.util.*;

public class FunctionScope implements Scope {
    private final Map<String, Symbol> arguments = new LinkedHashMap<>();
    private final Type type;
    private final Token token;
    private final Scope enclosingScope;

    public FunctionScope(Type type, Token token, Scope enclosingScope) {
        this.type = type;
        this.token = token;
        this.enclosingScope = enclosingScope;
    }

//    public boolean exist(Symbol symbol) {
//        return arguments.containsKey(symbol.getName());
//    }

    public boolean exist(String name) {
        return arguments.containsKey(name);
    }

    public Type getType() {
        return type;
    }

    @Override
    public void define(Symbol symbol) {
        arguments.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name) {
        Symbol symbol = arguments.get(name);
        if (symbol != null) {
            return symbol;
        }
        if (enclosingScope != null) {
            return enclosingScope.resolve(name);
        }
        return null;
    }

    @Override
    public String getScopeName() {
        return String.format("function %s's scope", token.getText());
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public Token getToken() {
        return token;
    }
}
