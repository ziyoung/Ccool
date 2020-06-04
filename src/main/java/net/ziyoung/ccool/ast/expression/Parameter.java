package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeName;
import org.antlr.v4.runtime.Token;

public class Parameter implements Expression {
    private final TypeName typeName;
    private final Token token;
    private Type type;

    public Parameter(TypeName typeName, Token token) {
        this.typeName = typeName;
        this.token = token;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public Token getToken() {
        return token;
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
        return visitor.visitParameter(this, context);
    }
}
