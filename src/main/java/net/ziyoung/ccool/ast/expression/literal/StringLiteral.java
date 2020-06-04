package net.ziyoung.ccool.ast.expression.literal;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;

public class StringLiteral extends Literal {
    public StringLiteral(Token token) {
        super(token);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStringLiteral(this, context);
    }

    @Override
    public Type getType() {
        return Types._string;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StringLiteral literal = (StringLiteral) obj;
        return this.equals(literal);
    }
}
