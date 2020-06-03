package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.context.builtin.Builtin;
import net.ziyoung.ccool.context.builtin.BuiltinFunction;
import net.ziyoung.ccool.type.PrimaryType;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;

public class CompilationUnitContext extends Context {
    public CompilationUnitContext(CompilationUnit owner) {
        super(owner, null, null, null);
        definePrimaryTypes();
        defineBuiltinFunctions();
    }

    // For a primary type or builtin function, there is no token for it.
    private void definePrimaryTypes() {
        for (PrimaryType primaryType : Types.getPrimaryTypes()) {
            TypeDefinition typeDefinition = new TypeDefinition(primaryType);
            define(primaryType.getName(), typeDefinition);
        }
    }

    private void defineBuiltinFunctions() {
        for (MethodDefinition method : Builtin.builtinMethods) {
            define(((BuiltinFunction) method).getName(), method);
        }
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
