package net.ziyoung.ccool.ast.expression.arithmetic;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.expression.BinaryExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import org.antlr.v4.runtime.Token;

public class AddExpression extends BinaryExpression {
    public AddExpression(Token token, Expression lhs, Expression rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitAddExpression(this, context);
    }
}
