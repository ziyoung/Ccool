package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public class VariableExpression extends Expression {
    public VariableExpression(Token token) {
        super(token);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitVariableExpression(this, context);
    }
}
