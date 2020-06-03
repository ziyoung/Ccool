package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.expression.CallExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.expression.literal.IntLiteral;
import net.ziyoung.ccool.ast.expression.literal.StringLiteral;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.context.builtin.BuiltinFunction;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

class ExpressionResolve extends AstBaseVisitor<Object, Context> {
    @Override
    public Object visitStringLiteral(StringLiteral node, Context context) {
        return node.getToken().getText();
    }

    @Override
    public Object visitIntLiteral(IntLiteral node, Context context) {
        return Integer.valueOf(node.getToken().getText());
    }

    @Override
    public Object visitVariableExpression(VariableExpression node, Context context) {
        return context.resolve(node.getToken().getText());
    }
}

class MethodGenerate extends AstBaseVisitor<Void, MethodVisitor> {
    private static final ExpressionResolve expressionResolve = new ExpressionResolve();
    private LocalContext localContext;

    @Override
    public Void visitMethodDeclaration(MethodDeclaration node, MethodVisitor methodVisitor) {
        MethodContext context = node.getContext();
        System.out.printf("parameters %s\n", context.getParameters());
        // TODO: 如何为形参分配？？？？
        visitBlockStatement(node.getBody(), methodVisitor);
        return null;
    }

    @Override
    public Void visitBlockStatement(BlockStatement node, MethodVisitor methodVisitor) {
        this.localContext = node.getContext();
        System.out.printf("visitBlockStatement local context is %s\n", this.localContext);
        for (Statement statement : node.getStatements()) {
            visitStatement(statement, methodVisitor);
        }
        return null;
    }

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, MethodVisitor methodVisitor) {
        String name = node.getToken().getText();
        Expression expression = node.getExpression();
        Object resolvedValue = expressionResolve.visitExpression(expression, this.localContext);
        System.out.printf("resolved value is %s local context is %s\n", resolvedValue, this.localContext);
        VariableDefinition variableDefinition = (VariableDefinition) this.localContext.resolve(name);
        int offset = variableDefinition.getOffset();
        methodVisitor.visitLdcInsn(resolvedValue);
        Type type = variableDefinition.getType();
        if (Types.isIntType(type)) {
            methodVisitor.visitVarInsn(ISTORE, offset);
        } else if (Types.isStringType(type)) {
            methodVisitor.visitVarInsn(ASTORE, offset);
        }
        return null;
    }

    @Override
    public Void visitCallExpression(CallExpression node, MethodVisitor methodVisitor) {
        Expression expression = node.getLhs();
        List<Expression> arguments = node.getArguments();
        if (expression instanceof VariableExpression) {
            Token token = ((VariableExpression) expression).getToken();
            MethodDefinition methodDefinition = localContext.getClassContext().resolveMethod(token.getText());
            // FIXME: add more methods.
            BuiltinFunction builtinFunction = (BuiltinFunction) methodDefinition;
            Object value = expressionResolve.visitExpression(arguments.get(0), localContext);
            if (value instanceof VariableDefinition && builtinFunction != null) {
                System.out.println("generate class file for print(var)");
                VariableDefinition variableDefinition = (VariableDefinition) value;
                Type type = variableDefinition.getType();
                int offset = variableDefinition.getOffset();
                methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                if (Types.isIntType(type)) {
                    methodVisitor.visitVarInsn(ILOAD, offset);
                    methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
                } else if (Types.isStringType(type)) {
                    methodVisitor.visitVarInsn(ALOAD, offset);
                    methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                }
            }
        }
        return null;
    }
}

public class GeneratePhase extends AstBaseVisitor<Void, ClassWriter> {
    //    private ClassContext classContext;
    private final static MethodGenerate methodGenerate = new MethodGenerate();

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
//        this.classContext = node.getContext();
        System.out.println("visitClassDeclaration run -->");
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
//        System.out.println("visitMethodDeclaration run -->");
//        MethodDefinition methodDefinition = (MethodDefinition) classContext.resolve(name);
        MethodVisitor methodVisitor = classWriter.visitMethod(
                ACC_PUBLIC + ACC_STATIC,
                name,
                "([Ljava/lang/String;)V",
                null,
                null
        );
        methodVisitor.visitCode();
        methodGenerate.visitMethodDeclaration(node, methodVisitor);
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(2, 2);
        // Don't forget to call visitEnd.
        methodVisitor.visitEnd();
        return null;
    }
}
