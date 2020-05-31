package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public class VariableExpression implements Expression {
    private final Token token;

    public VariableExpression(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitVariableExpression(this, context);
    }
}
