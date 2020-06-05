package net.ziyoung.ccool.ast.expression.literal;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.expression.Expression;
import org.antlr.v4.runtime.Token;

public abstract class Literal extends Expression {
    public Literal(Token token) {
        super(token);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitLiteral(this, context);
    }
}
