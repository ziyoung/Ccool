package net.ziyoung.ccool.ast;

import net.ziyoung.ccool.ast.statement.ClassDeclaration;
import net.ziyoung.ccool.context.CompilationUnitContext;

import java.util.List;

public class CompilationUnit implements Node {
    private final String packageName;
    private final List<ClassDeclaration> declarations;
    private CompilationUnitContext context;

    public CompilationUnit(String packageName, List<ClassDeclaration> declarations) {
        this.packageName = packageName;
        this.declarations = declarations;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<ClassDeclaration> getDeclarations() {
        return declarations;
    }

    public CompilationUnitContext getContext() {
        return context;
    }

    public void setContext(CompilationUnitContext context) {
        this.context = context;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCompilationUnit(this, context);
    }
}
