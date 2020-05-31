package net.ziyoung.ccool.scope;

import net.ziyoung.ccool.type.Type;

public abstract class Symbol {
    private final String name;

    public Symbol(String name) {
        this.name = name;
    }

    public boolean isType() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    public Type getType() {
        return null;
    }

    public String getName() {
        return name;
    }

//    public Object getValue() {
//        return null;
//    }
}
