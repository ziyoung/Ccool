package net.ziyoung.ccool.ast.expression;

import org.antlr.v4.runtime.Token;

public abstract class UnaryExpression extends Expression {
    private final Expression rhs;

    public UnaryExpression(Token token, Expression rhs) {
        super(token);
        this.rhs = rhs;
    }

    public Expression getRhs() {
        return rhs;
    }
}

