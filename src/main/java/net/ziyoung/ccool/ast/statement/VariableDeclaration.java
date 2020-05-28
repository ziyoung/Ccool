package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.ast.expression.Expression;
import org.antlr.v4.runtime.Token;

public class VariableDeclaration implements Statement {
    private final Type type;
    private final Token name;
    private final Expression expression;

    public VariableDeclaration(Type type, Token name, Expression expression) {
        this.type = type;
        this.name = name;
        this.expression = expression;
    }

    public Type getType() {
        return type;
    }

    public Token getName() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitVariableDeclaration(this, context);
    }
}
