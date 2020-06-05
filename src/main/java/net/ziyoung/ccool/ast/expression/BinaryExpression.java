package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public abstract class BinaryExpression extends Expression {
    private final Expression lhs;
    private final Expression rhs;

    public BinaryExpression(Token token, Expression lhs, Expression rhs) {
        super(token);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Expression getLhs() {
        return lhs;
    }

    public Expression getRhs() {
        return rhs;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitBinaryExpression(this, context);
    }
}
