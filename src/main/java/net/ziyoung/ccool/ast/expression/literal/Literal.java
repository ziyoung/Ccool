package net.ziyoung.ccool.ast.expression.literal;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.expression.Expression;
import org.antlr.v4.runtime.Token;

public abstract class Literal implements Expression {
    private final Token value;

    public Literal(Token value) {
        this.value = value;
    }

    public Token getValue() {
        return value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitLiteral(this, context);
    }
}
