package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.context.ClassContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class ClassDeclaration implements Statement {
    private final Token token;
    private final List<Statement> members;
    private ClassContext context;

    public ClassDeclaration(Token token, List<Statement> members) {
        this.token = token;
        this.members = members;
    }

    public Token getToken() {
        return token;
    }

    public List<Statement> getMembers() {
        return members;
    }

    public ClassContext getContext() {
        return context;
    }

    public void setContext(ClassContext context) {
        this.context = context;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitClassDeclaration(this, context);
    }
}
