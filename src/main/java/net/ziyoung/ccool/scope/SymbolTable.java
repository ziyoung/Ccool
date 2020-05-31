package net.ziyoung.ccool.scope;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;

import java.util.IdentityHashMap;
import java.util.Map;

public class SymbolTable implements AstVisitor<Void, Scope> {
    private final Map<Node, Scope> scopes = new IdentityHashMap<>();
    private final GlobalScope globalScope = new GlobalScope();
    private Scope currentScope;

    public Map<Node, Scope> getScopes() {
        return scopes;
    }

    public GlobalScope getGlobalScope() {
        return globalScope;
    }

    @Override
    public Void visitNode(Node node, Scope context) {
        return null;
    }

    @Override
    public Void visitStatement(Statement node, Scope context) {
        if (node instanceof BlockStatement) {
            visitBlockStatement((BlockStatement) node, context);
        } else if (node instanceof ExpressionStatement) {
            visitExpressionStatement((ExpressionStatement) node, context);
        } else if (node instanceof FunctionStatement) {
            visitFunctionStatement((FunctionStatement) node, context);
        } else if (node instanceof VariableDeclaration) {
            visitVariableDeclaration((VariableDeclaration) node, context);
        }
        return null;
    }

    @Override
    public Void visitExpression(Expression node, Scope context) {
        return null;
    }

    @Override
    public Void visitLiteral(Literal node, Scope context) {
        return null;
    }

    @Override
    public Void visitBoolLiteral(BoolLiteral node, Scope context) {
        return null;
    }

    @Override
    public Void visitIntLiteral(IntLiteral node, Scope context) {
        return null;
    }

    @Override
    public Void visitDoubleLiteral(DoubleLiteral node, Scope context) {
        return null;
    }

    @Override
    public Void visitStringLiteral(StringLiteral node, Scope context) {
        return null;
    }

    @Override
    public Void visitNullLiteral(NullLiteral node, Scope context) {
        return null;
    }

    @Override
    public Void visitVariableExpression(VariableExpression node, Scope context) {
        return null;
    }

    @Override
    public Void visitParameter(Parameter node, Scope context) {
        return null;
    }

    @Override
    public Void visitCallExpression(CallExpression node, Scope context) {
        return null;
    }

    @Override
    public Void visitAssignExpression(AssignExpression node, Scope context) {
        return null;
    }

    @Override
    public Void visitExpressionStatement(ExpressionStatement node, Scope context) {
        return null;
    }

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, Scope context) {
        return null;
    }

    @Override
    public Void visitBlockStatement(BlockStatement node, Scope context) {
        return null;
    }

    @Override
    public Void visitFunctionStatement(FunctionStatement node, Scope context) {

        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnit node, Scope context) {
        for (Statement statement : node.getStatements()) {
            visitStatement(statement, globalScope);
        }
        return null;
    }
}
