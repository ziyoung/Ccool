package net.ziyoung.ccool.scope;

import net.ziyoung.ccool.type.PrimaryType;
import net.ziyoung.ccool.type.Types;

public class GlobalScope extends BaseScope {
    public GlobalScope() {
        super(null);
        definePrimaryTypes();
    }

    private void definePrimaryTypes() {
        for (PrimaryType type : Types.primaryTypes) {
            define(type);
        }
    }

    @Override
    public String getScopeName() {
        return "global";
    }
}
