package net.ziyoung.ccool.phase.visitor;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.expression.CallExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.statement.BlockStatement;
import net.ziyoung.ccool.ast.statement.Statement;
import net.ziyoung.ccool.ast.statement.VariableDeclaration;
import net.ziyoung.ccool.builtin.BuiltinFunction;
import net.ziyoung.ccool.context.LocalContext;
import net.ziyoung.ccool.context.MethodDefinition;
import net.ziyoung.ccool.context.VariableDefinition;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;


// TODO: add label for statement.
public class StatementGenerator extends AstBaseVisitor<Void, MethodVisitor> {
    private LocalContext localContext;
    private ExpressionGenerator expressionGenerator;

    @Override
    public Void visitBlockStatement(BlockStatement node, MethodVisitor methodVisitor) {
        LocalContext prevContext = this.localContext;
        ExpressionGenerator prevGenerator = this.expressionGenerator;

        this.localContext = node.getContext();
        this.expressionGenerator = new ExpressionGenerator(this.localContext);
        for (Statement statement : node.getStatements()) {
            visitStatement(statement, methodVisitor);
        }

        this.localContext = prevContext;
        this.expressionGenerator = prevGenerator;
        return null;
    }

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, MethodVisitor methodVisitor) {
        Expression expression = node.getExpression();
        expressionGenerator.visitExpression(expression, methodVisitor);
        String name = node.getToken().getText();
        VariableDefinition variableDefinition = (VariableDefinition) localContext.resolve(name);
        int offset = variableDefinition.getOffset();
        Type type = variableDefinition.getType();
        int opcode;
        if (type.isBool() || type.isInt()) {
            opcode = ISTORE;
        } else if (type.isDouble()) {
            opcode = DSTORE;
        } else if (type.isString()) {
            opcode = ASTORE;
        } else {
            throw new RuntimeException(String.format("unknown type %s", type));
        }
        methodVisitor.visitVarInsn(opcode, offset);
        return null;
    }

    @Override
    public Void visitCallExpression(CallExpression node, MethodVisitor methodVisitor) {
        Expression expression = node.getLhs();
        List<Expression> arguments = node.getArguments();
        if (expression instanceof VariableExpression) {
            Token token = ((VariableExpression) expression).getToken();
            MethodDefinition methodDefinition = localContext.getClassContext().resolveMethod(token.getText());
            if (methodDefinition instanceof BuiltinFunction) {
                BuiltinFunction builtinFunction = (BuiltinFunction) methodDefinition;
                builtinFunction.generate(methodVisitor, expressionGenerator, arguments);
            }
        }
        return null;
    }
}
