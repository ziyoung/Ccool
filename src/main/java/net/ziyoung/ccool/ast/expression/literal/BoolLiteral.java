package net.ziyoung.ccool.ast.expression.literal;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;

public class BoolLiteral extends Literal {
    public BoolLiteral(Token token) {
        super(token);
    }

    @Override
    public Type getType() {
        return Types._bool;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitBoolLiteral(this, context);
    }
}
