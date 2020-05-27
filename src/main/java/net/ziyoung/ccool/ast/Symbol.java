package net.ziyoung.ccool.ast;

public class Symbol {
    private final String name;
    private Type type;

    public Symbol(String name) {
        this.name = name;
    }

    public Symbol(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
