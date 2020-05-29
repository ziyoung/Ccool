package net.ziyoung.ccool.scope;

public class ValueSymbol extends Symbol {
    public ValueSymbol(String name) {
        super(name);
    }

    @Override
    public boolean isValue() {
        return true;
    }
}
