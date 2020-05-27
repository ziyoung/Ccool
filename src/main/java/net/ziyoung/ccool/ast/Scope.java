package net.ziyoung.ccool.ast;

public interface Scope {
    public String getScopeName();

    public Scope getEnclosingScope();

//    public Scope getParentScope();

    public void define(Symbol symbol);

    public Symbol resolve(String name);
}
