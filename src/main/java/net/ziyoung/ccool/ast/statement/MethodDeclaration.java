package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.context.MethodContext;
import net.ziyoung.ccool.ast.expression.Parameter;
import net.ziyoung.ccool.type.TypeName;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class MethodDeclaration implements Statement {
    private final TypeName typeName;
    private final Token token;
    private final List<Parameter> parameters;
    private final BlockStatement body;
    private MethodContext context;

    public MethodDeclaration(TypeName typeName, Token token, List<Parameter> parameters, BlockStatement body) {
        this.typeName = typeName;
        this.token = token;
        this.parameters = parameters;
        this.body = body;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public Token getToken() {
        return token;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public BlockStatement getBody() {
        return body;
    }

    public MethodContext getContext() {
        return context;
    }

    public void setContext(MethodContext context) {
        this.context = context;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMethodDeclaration(this, context);
    }
}
