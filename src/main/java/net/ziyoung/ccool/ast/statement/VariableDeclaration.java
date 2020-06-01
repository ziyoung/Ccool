package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.type.TypeName;
import org.antlr.v4.runtime.Token;

public class VariableDeclaration implements Statement {
    private final TypeName typeName;
    private final Token token;
    private final Expression expression;

    public VariableDeclaration(TypeName typeName, Token token, Expression expression) {
        this.typeName = typeName;
        this.token = token;
        this.expression = expression;
    }


    public TypeName getTypeName() {
        return typeName;
    }

    public Token getToken() {
        return token;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitVariableDeclaration(this, context);
    }
}
