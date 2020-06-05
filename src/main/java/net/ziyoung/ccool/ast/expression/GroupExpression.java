package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public class GroupExpression extends UnaryExpression {
    public GroupExpression(Token token, Expression rhs) {
        super(token, rhs);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitGroupExpression(this, context);
    }
}
