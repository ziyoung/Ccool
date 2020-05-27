package net.ziyoung.ccool.ast;

public class GlobalScope extends BaseScope {
    public GlobalScope() {
        super(null);
        definePrimaryTypes();
    }

    private void definePrimaryTypes() {
        for (PrimaryType type : SymbolTable.primaryTypes) {
            define(type);
        }
    }

    @Override
    public String getScopeName() {
        return "global";
    }
}
