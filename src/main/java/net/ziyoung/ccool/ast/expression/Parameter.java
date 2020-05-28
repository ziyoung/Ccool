package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

public class Parameter implements Expression {
    private final Type type;
    private final Token name;

    public Parameter(Type type, Token name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public Token getName() {
        return name;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitParameter(this, context);
    }
}
