package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.context.LocalContext;

import java.util.List;

public class BlockStatement implements Statement {
    private final List<Statement> statements;
    private LocalContext context;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public LocalContext getContext() {
        return context;
    }

    public void setContext(LocalContext context) {
        this.context = context;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitBlockStatement(this, context);
    }
}
