package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public class VariableExpression implements Expression {
    private final Token name;
    // TODO: add Type for variable.

    public VariableExpression(Token name) {
        this.name = name;
    }

    public Token getName() {
        return name;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitVariableExpression(this, context);
    }
}
