package net.ziyoung.ccool.ast.statement;

import net.ziyoung.ccool.ast.AstVisitor;

import java.util.List;

public class BlockStatement implements Statement {
    private final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitBlockStatement(this, context);
    }
}
