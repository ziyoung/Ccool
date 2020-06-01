package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.type.PrimaryType;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

public class CompilationUnitContext extends Context {
    public CompilationUnitContext(CompilationUnit owner) {
        super(owner, null, null, null);
    }

    // For a primary type, we has no token for it.
    public void definePrimaryType(PrimaryType primaryType) {
        TypeDefinition typeDefinition = new TypeDefinition(primaryType);
        define(primaryType.getName(), typeDefinition);
    }

    public void defineUserType(Token token, Type type) {
        TypeDefinition typeDefinition = new TypeDefinition(type);
        define(token, typeDefinition);
    }

    @Override
    public String getContextName() {
        return "ComplicationUnit";
    }
}
