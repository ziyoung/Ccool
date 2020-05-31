package net.ziyoung.ccool.scope;

import org.antlr.v4.runtime.Token;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseScope implements Scope {
    private final Scope compilationUnitScope;
    private final Scope enclosingScope;
    private final Scope classScope;
    protected final Map<String, Definition> definitions = new LinkedHashMap<>();

    public BaseScope(Scope compilationUnitScope, Scope enclosingScope) {
        this.compilationUnitScope = compilationUnitScope;
        this.enclosingScope = enclosingScope;
        classScope = null;
    }

    public BaseScope(Scope compilationUnitScope, Scope enclosingScope, Scope classScope) {
        this.compilationUnitScope = compilationUnitScope;
        this.enclosingScope = enclosingScope;
        this.classScope = classScope;
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    @Override
    public void define(Token token, Definition definition) {
        String name = token.getText();
        if (definitions.containsKey(name)) {
            System.err.println("error");
            return;
        }
        definitions.put(name, definition);
    }

    @Override
    public Definition resolve(String name) {
        Definition definition = definitions.get(name);
        if (definition != null) {
            return definition;
        }
        if (enclosingScope != null) {
            return enclosingScope.resolve(name);
        }
        return null;
    }
}
