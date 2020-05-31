package net.ziyoung.ccool.scope;

public class LocalScope extends BaseScope {
    public LocalScope(Scope compilationUnitScope, Scope enclosingScope) {
        super(compilationUnitScope, enclosingScope);
    }

    public LocalScope(Scope compilationUnitScope, Scope enclosingScope, Scope classScope) {
        super(compilationUnitScope, enclosingScope, classScope);
    }

    @Override
    public String getScopeName() {
        return "local";
    }
}
