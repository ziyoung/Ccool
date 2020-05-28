package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.expression.Expression;

public class ExpressionStatement implements Statement {
    private final Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitExpressionStatement(this, context);
    }
}
