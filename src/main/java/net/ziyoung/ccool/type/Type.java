package net.ziyoung.ccool.type;

import net.ziyoung.ccool.scope.Symbol;

public abstract class Type extends Symbol {
    public Type(String name) {
        super(name);
    }

    public abstract int getTypeIndex();

    // FIXME: canAssignTo needs to be implemented.
    public boolean canAssignTo(Type destType) {
        return false;
    }

    @Override
    public boolean isType() {
        return super.isType();
    }

    @Override
    public Type getType() {
        return this;
    }
}
