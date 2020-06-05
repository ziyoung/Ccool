package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.TypeName;
import org.antlr.v4.runtime.Token;

public class Parameter extends Expression {
    private final TypeName typeName;

    public Parameter(Token token, TypeName typeName) {
        super(token);
        this.typeName = typeName;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitParameter(this, context);
    }
}
