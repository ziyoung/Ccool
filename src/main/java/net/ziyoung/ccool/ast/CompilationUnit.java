package net.ziyoung.ccool.ast;

import net.ziyoung.ccool.ast.statement.Statement;

import java.util.List;

public class CompilationUnit implements Node {
    private final List<Statement> statements;

    public CompilationUnit(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCompilationUnit(this, context);
    }
}
