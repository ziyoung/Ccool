package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.ast.expression.Parameter;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class FunctionStatement implements Statement {
    private final Type type;
    private final Token name;
    private final List<Parameter> parameters;
    private final BlockStatement body;

    public FunctionStatement(Type type, Token name, List<Parameter> parameters, BlockStatement body) {
        this.type = type;
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public Token getName() {
        return name;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public BlockStatement getBody() {
        return body;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFunctionStatement(this, context);
    }
}
