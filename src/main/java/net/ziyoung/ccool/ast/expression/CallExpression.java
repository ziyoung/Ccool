package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class CallExpression extends Expression {
    private final Expression lhs;
    private final List<Expression> arguments;

    public CallExpression(Token token, Expression lhs, List<Expression> arguments) {
        super(token);
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
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCallExpression(this, context);
    }
}
