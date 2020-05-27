package net.ziyoung.ccool.ast;

import org.antlr.v4.runtime.Token;

import java.util.*;

public class FunctionSymbolScope extends Symbol implements Scope {
    private final Map<String, Symbol> arguments = new LinkedHashMap<>();
    private final Token token;
    private final Scope enclosingScope;

    public FunctionSymbolScope(Type type, Token token, Scope enclosingScope) {
        super(type, token.getText());
        this.token = token;
        this.enclosingScope = enclosingScope;
    }

//    public boolean exist(Symbol symbol) {
//        return arguments.containsKey(symbol.getName());
//    }

    public boolean exist(String name) {
        return arguments.containsKey(name);
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
        return getName();
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public Token getToken() {
        return token;
    }
}
