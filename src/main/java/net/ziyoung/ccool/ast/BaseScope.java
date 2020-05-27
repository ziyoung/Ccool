package net.ziyoung.ccool.ast;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseScope implements Scope {
    private final Scope enclosingScope;
    private final Map<String, Symbol> symbols = new LinkedHashMap<>();

    public BaseScope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    @Override
    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol resolve(String name) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            return symbol;
        }
        if (enclosingScope != null) {
            return enclosingScope.resolve(name);
        }
        return null;
    }
}
