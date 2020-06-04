package net.ziyoung.ccool.builtin;

import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.context.MethodDefinition;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.phase.visitor.ExpressionGenerator;
import net.ziyoung.ccool.type.PrimaryType;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Collections;
import java.util.List;

import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class PrintFunction extends MethodDefinition implements BuiltinFunction {
    public PrintFunction() {
        super(Types._void, Collections.emptyList());
    }

    @Override
    public void checkCallArguments(Token token, List<Type> types) {
        if (types.size() > 1) {
            SemanticErrors.error(token, "print function receive 0 or 1 parameter");
        }
        if (types.size() == 1) {
            Type type = types.get(0);
            if (!(type instanceof PrimaryType)) {
                String functionName = getName();
                String typeName = type == null ? "invalid" : type.getName();
                SemanticErrors.error(token, String.format("%s's argument 0 expected primary-type but got %s", functionName, typeName));
            }
        }
//        for (int i = 0; i < types.size(); i++) {
//            Type type = types.get(i);
//            if (!(type instanceof PrimaryType)) {
//                String functionName = getName();
//                String typeName = type == null ? "invalid" : type.getName();
//                SemanticErrors.error(token, String.format("%s's argument %d expected primary-type but got %s", functionName, i, typeName));
//            }
//        }
    }

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public MethodVisitor generate(MethodVisitor visitor, ExpressionGenerator generator, List<Expression> arguments) {
        visitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        String descriptor = "";
        if (arguments.size() == 0) {
            descriptor = "()V";
        } else {
            Expression expression = arguments.get(0);
            generator.visitExpression(expression, visitor);
            descriptor = "(" + Types.getTypeDescriptor(expression.getType()) + ")V";
        }
        visitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", descriptor, false);
        return visitor;
    }
}
