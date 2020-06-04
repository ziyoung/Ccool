package net.ziyoung.ccool.builtin;

import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.phase.visitor.ExpressionGenerator;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

public interface BuiltinFunction {
    public String getName();

    public MethodVisitor generate(MethodVisitor visitor, ExpressionGenerator generator, List<Expression> arguments);
}
