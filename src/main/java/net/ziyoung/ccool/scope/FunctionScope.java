package net.ziyoung.ccool.scope;

public class FunctionScope extends LocalScope {
    public FunctionScope(Scope compilationUnitScope, Scope enclosingScope) {
        super(compilationUnitScope, enclosingScope);
    }

    public FunctionScope(Scope compilationUnitScope, Scope enclosingScope, Scope classScope) {
        super(compilationUnitScope, enclosingScope, classScope);
    }
}
