package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.statement.MethodDeclaration;
import net.ziyoung.ccool.type.Type;

public class MethodContext extends LocalContext {
    public MethodContext(MethodDeclaration owner, ClassContext classContext, CompilationUnitContext compilationUnitContext) {
        super(owner, null, classContext, compilationUnitContext);
    }

    public Type getReturnType() {
        return ((MethodDeclaration) owner).getTypeName();
    }
}
