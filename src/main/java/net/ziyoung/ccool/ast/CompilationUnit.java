package net.ziyoung.ccool.ast;

import net.ziyoung.ccool.ast.statement.Statement;

import java.util.List;

public class CompilationUnit implements Node {
    private final String packageName;
    private final List<Statement> statements;
//    private final List<TypeName> typeNames;

    public CompilationUnit(String packageName, List<Statement> statements) {
        this.packageName = packageName;
        this.statements = statements;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCompilationUnit(this, context);
    }
}
