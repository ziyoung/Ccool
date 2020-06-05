package net.ziyoung.ccool.phase.visitor;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.expression.literal.BoolLiteral;
import net.ziyoung.ccool.ast.expression.literal.DoubleLiteral;
import net.ziyoung.ccool.ast.expression.literal.IntLiteral;
import net.ziyoung.ccool.ast.expression.literal.StringLiteral;
import net.ziyoung.ccool.context.LocalContext;
import net.ziyoung.ccool.context.VariableDefinition;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class ExpressionGenerator extends AstBaseVisitor<Void, MethodVisitor> {
    private final LocalContext localContext;

    public ExpressionGenerator(LocalContext localContext) {
        this.localContext = localContext;
    }

    @Override
    public Void visitBoolLiteral(BoolLiteral node, MethodVisitor methodVisitor) {
        String literal = node.getToken().getText();
        int opcode = literal.equals("true") ? ICONST_1 : ICONST_0;
        methodVisitor.visitInsn(opcode);
        return null;
    }

    @Override
    public Void visitIntLiteral(IntLiteral node, MethodVisitor methodVisitor) {
        Token token = node.getToken();
        int integer = Integer.parseInt(token.getText());
        if (Byte.MIN_VALUE <= integer && integer <= Byte.MAX_VALUE) {
            methodVisitor.visitIntInsn(BIPUSH, integer);
        } else if (Short.MIN_VALUE <= integer && integer <= Short.MAX_VALUE) {
            methodVisitor.visitIntInsn(SIPUSH, integer);
        } else {
            methodVisitor.visitLdcInsn(integer);
        }
        return null;
    }

    @Override
    public Void visitDoubleLiteral(DoubleLiteral node, MethodVisitor methodVisitor) {
        Token token = node.getToken();
        Double d = Double.valueOf(token.getText());
        methodVisitor.visitLdcInsn(d);
        return null;
    }

    @Override
    public Void visitStringLiteral(StringLiteral node, MethodVisitor methodVisitor) {
        Token token = node.getToken();
        methodVisitor.visitLdcInsn(token.getText());
        return null;
    }

    @Override
    public Void visitVariableExpression(VariableExpression node, MethodVisitor methodVisitor) {
        String name = node.getToken().getText();
        VariableDefinition variableDefinition = (VariableDefinition) localContext.resolve(name);
        int offset = variableDefinition.getOffset();
        Type type = variableDefinition.getType();
        int opcode;
        if (type.isBool() || type.isInt()) {
            opcode = ILOAD;
        } else if (type.isString()) {
            opcode = ALOAD;
        } else if (type.isDouble()) {
            opcode = DLOAD;
        } else {
            throw new RuntimeException(String.format("unknown type %s", type));
        }
        methodVisitor.visitVarInsn(opcode, offset);
        return null;
    }
}
