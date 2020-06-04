package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;

import java.util.List;

public class CallExpression implements Expression {
    private final Expression lhs;
    private final List<Expression> arguments;
    private Type type;

    public CallExpression(Expression lhs, List<Expression> arguments) {
        this.lhs = lhs;
        this.arguments = arguments;
    }

    public Expression getLhs() {
        return lhs;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCallExpression(this, context);
    }
}
