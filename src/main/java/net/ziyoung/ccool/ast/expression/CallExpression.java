package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class CallExpression implements Expression {
    private final Token function;
    private final List<Expression> arguments;

    public CallExpression(Token function, List<Expression> arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    public Token getFunction() {
        return function;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCallExpression(this, context);
    }
}
