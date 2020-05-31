package net.ziyoung.ccool.scope;

public class CompilationUnitScope extends BaseScope {

    public CompilationUnitScope() {
        super(null, null);
    }

    @Override
    public String getScopeName() {
        return "CompilationUnitScope";
    }
}
