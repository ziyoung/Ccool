package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.statement.ClassDeclaration;

public class ClassContext extends LocalContext {
    public ClassContext(ClassDeclaration owner, CompilationUnitContext compilationUnitContext) {
        super(owner, null, null, compilationUnitContext);
    }

    @Override
    public String getContextName() {
        return "Class";
    }
}
