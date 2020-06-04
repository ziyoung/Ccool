package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.phase.visitor.StatementGenerator;
import net.ziyoung.ccool.type.Types;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class GeneratePhase extends AstBaseVisitor<Void, ClassWriter> {
    @Override
    public Void visitCompilationUnit(CompilationUnit node, ClassWriter classWriter) {
        for (ClassDeclaration declaration : node.getDeclarations()) {
            visitClassDeclaration(declaration, classWriter);
        }
        // Don't forget to call visitEnd.
        classWriter.visitEnd();
        return null;
    }

    @Override
    public Void visitClassDeclaration(ClassDeclaration node, ClassWriter classWriter) {
        String name = node.getToken().getText();
        classWriter.visit(52, ACC_PUBLIC, name, null, "java/lang/Object", null);
        ClassContext classContext = node.getContext();
        for (FieldDefinition field : classContext.getFields()) {
            classWriter.visitField(
                    ACC_PUBLIC + ACC_STATIC,
                    field.getName(),
                    Types.getTypeDescriptor(field.getType()),
                    null,
                    123
            ).visitEnd();
        }
        for (Statement member : node.getMembers()) {
            if (member instanceof MethodDeclaration) {
                visitMethodDeclaration((MethodDeclaration) member, classWriter);
            }
        }
        return null;
    }

    @Override
    public Void visitMethodDeclaration(MethodDeclaration node, ClassWriter classWriter) {
        String name = node.getToken().getText();
        MethodContext methodContext = node.getContext();
        // TODO: support other methods. Right now only static main function is supported.
        MethodVisitor methodVisitor = classWriter.visitMethod(
                ACC_PUBLIC + ACC_STATIC,
                name,
                "([Ljava/lang/String;)V",
                null,
                null
        );
        methodVisitor.visitCode();

        StatementGenerator statementGenerator = new StatementGenerator();
        statementGenerator.visitBlockStatement(node.getBody(), methodVisitor);

        methodVisitor.visitInsn(RETURN);
        // We also can use ClassWriter.COMPUTE_MAXS, see https://asm.ow2.io/javadoc/org/objectweb/asm/ClassWriter.html#COMPUTE_MAXS
        // TODO: compute stack size.
        methodVisitor.visitMaxs(2, methodContext.getLocalsSize());
        // Don't forget to call visitEnd.
        methodVisitor.visitEnd();
        return null;
    }
}
