package net.ziyoung.ccool.ast;

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
