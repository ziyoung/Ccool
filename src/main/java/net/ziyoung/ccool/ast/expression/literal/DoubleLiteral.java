package net.ziyoung.ccool.ast.expression.literal;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

public class DoubleLiteral extends Literal {
    public DoubleLiteral(Token value) {
        super(value);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDoubleLiteral(this, context);
    }
}
