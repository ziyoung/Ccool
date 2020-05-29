package net.ziyoung.ccool.scope;

import java.util.List;

public class CompilationUnitScope extends BaseScope {
    private final GlobalScope globalScope = new GlobalScope();
    private final List<Scope> childrenScopes;

    public CompilationUnitScope(List<Scope> childrenScopes) {
        super(null);
        this.childrenScopes = childrenScopes;
    }

    public GlobalScope getGlobalScope() {
        return globalScope;
    }

    public List<Scope> getChildrenScopes() {
        return childrenScopes;
    }

    @Override
    public String getScopeName() {
        return "CompilationUnit";
    }
}
