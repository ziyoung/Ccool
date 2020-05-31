package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;

public class AssignExpression implements Expression {
    private final Expression lhs;
    private final Expression rhs;

    public AssignExpression(Expression lhs, Expression rhs) {
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
        return visitor.visitAssignExpression(this, context);
    }
}
