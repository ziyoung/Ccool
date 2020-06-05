package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public class AssignExpression extends BinaryExpression {
    public AssignExpression(Token token, Expression lhs, Expression rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitAssignExpression(this, context);
    }
}
