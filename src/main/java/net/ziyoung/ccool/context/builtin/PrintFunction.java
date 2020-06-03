package net.ziyoung.ccool.context.builtin;

import net.ziyoung.ccool.context.MethodDefinition;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.PrimaryType;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Collections;
import java.util.List;

public class PrintFunction extends MethodDefinition implements BuiltinFunction {
    public PrintFunction() {
        super(Types._void, Collections.emptyList());
    }

    @Override
    public void checkCallArguments(Token token, List<Type> types) {
        for (int i = 0; i < types.size(); i++) {
            Type type = types.get(i);
            if (!(type instanceof PrimaryType)) {
                String functionName = getName();
                String typeName = type == null ? "invalid" : type.getName();
                SemanticErrors.error(token, String.format("%s's argument %d expected primary-type but got %s", functionName, i, typeName));
            }
        }
    }

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public MethodVisitor generate(MethodVisitor visitor) {
        System.out.println("TODO: we need generate opcodes for print function");
        return visitor;
    }
}
