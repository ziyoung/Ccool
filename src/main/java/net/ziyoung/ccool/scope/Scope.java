package net.ziyoung.ccool.scope;

import org.antlr.v4.runtime.Token;

public interface Scope {
    public String getScopeName();

    public Scope getEnclosingScope();

//    public Scope getParentScope();

    public void define(Token token, Definition definition);

    public Definition resolve(String name);
}
