package net.ziyoung.ccool.scope;

public class GlobalScope extends BaseScope {
    public GlobalScope() {
        super(null);
        definePrimaryTypes();
    }

    private void definePrimaryTypes() {
//        for (PrimaryType type : Types.primaryTypes) {
//            define(type);
//        }
    }

    @Override
    public String getScopeName() {
        return "global";
    }
}
