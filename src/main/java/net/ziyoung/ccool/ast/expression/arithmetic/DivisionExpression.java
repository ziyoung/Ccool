package net.ziyoung.ccool.ast.expression.arithmetic;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.expression.BinaryExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import org.antlr.v4.runtime.Token;

public class DivisionExpression extends BinaryExpression {
    public DivisionExpression(Token token, Expression lhs, Expression rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDivisionExpression(this, context);
    }
}
