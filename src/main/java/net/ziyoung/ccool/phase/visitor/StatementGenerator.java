package net.ziyoung.ccool.phase.visitor;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.expression.CallExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.builtin.BuiltinFunction;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

import java.util.List;


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
            if (methodDefinition instanceof BuiltinFunction) {
                BuiltinFunction builtinFunction = (BuiltinFunction) methodDefinition;
                builtinFunction.generate(methodVisitor, expressionGenerator, arguments);
            }
        }
        return null;
    }
}
