package net.ziyoung.ccool.context.builtin;

import org.objectweb.asm.MethodVisitor;

public interface BuiltinFunction {
    public String getName();
    public MethodVisitor generate(MethodVisitor visitor);
}
