package net.ziyoung.ccool.parser;

import net.ziyoung.ccool.antlr.CcoolBaseVisitor;
import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.ast.expression.CallExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.expression.Parameter;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class AstBuilder extends CcoolBaseVisitor<Node> {
    @Override
    public CompilationUnit visitCompilationUnit(CcoolParser.CompilationUnitContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            Node node = visit(child);
            System.out.printf("child _> %s\n", node);
            if (node instanceof Statement) {
                Statement statement = (Statement) node;
                statements.add(statement);
            } else {
                throw new RuntimeException(String.format("Should get statement rather than %s", node));
            }
        }
        return new CompilationUnit(statements);
    }

    @Override
    public FunctionStatement visitMethodDeclaration(CcoolParser.MethodDeclarationContext ctx) {
        Token token = ctx.ID().getSymbol();
        Type type = Types.typeContextToType(ctx.type());
        List<Parameter> parameters = new ArrayList<>();
        CcoolParser.FormalParametersContext parametersContext = ctx.formalParameters();
        if (parametersContext != null) {
            int index = 0;
            for (CcoolParser.TypeContext typeContext : parametersContext.type()) {
                Type type1 = Types.typeContextToType(typeContext);
                Token token1 = parametersContext.ID(index).getSymbol();
                Parameter parameter = new Parameter(type1, token1);
                parameters.add(parameter);
            }
        }
        BlockStatement blockStatement = visitBlock(ctx.block());
        return new FunctionStatement(type, token, parameters, blockStatement);
    }

    @Override
    public BlockStatement visitBlock(CcoolParser.BlockContext ctx) {
        List<Statement> statements = new ArrayList<>();
        for (CcoolParser.StatementContext statementContext : ctx.statement()) {
            Statement statement = visitStatement(statementContext);
            statements.add(statement);
        }
        return new BlockStatement(statements);
    }

    @Override
    public Statement visitStatement(CcoolParser.StatementContext ctx) {
        if (ctx.block() != null) {
            return visitBlock(ctx.block());
        } else if (ctx.varDeclaration() != null) {
            return visitVarDeclaration(ctx.varDeclaration());
        } else if (ctx.expression() != null) {
            Expression expression = (Expression) visit(ctx.expression());
            return new ExpressionStatement(expression);
        }
        throw new RuntimeException(String.format("Invalid statement %s", ctx));
    }

    @Override
    public VariableDeclaration visitVarDeclaration(CcoolParser.VarDeclarationContext ctx) {
        Type type = Types.typeContextToType(ctx.type());
        Token token = ctx.ID().getSymbol();
        Expression expression = null;
        CcoolParser.ExpressionContext expressionContext = ctx.expression();
        if (expressionContext != null) {
            expression = (Expression) visit(expressionContext);
        }
        return new VariableDeclaration(type, token, expression);
    }

    @Override
    public CallExpression visitCall(CcoolParser.CallContext ctx) {
        Token token = ctx.ID().getSymbol();
        List<Expression> arguments = new ArrayList<>();
        CcoolParser.ExpressionListContext listContext = ctx.expressionList();
        if (listContext != null) {
            for (CcoolParser.ExpressionContext expressionContext : listContext.expression()) {
                Expression expression = (Expression) visit(expressionContext);
                arguments.add(expression);
            }
        }
        return new CallExpression(token, arguments);
    }

    @Override
    public Literal visitLiteral(CcoolParser.LiteralContext ctx) {
        if (ctx.BOOL() != null) {
            return new BoolLiteral(ctx.BOOL().getSymbol());
        } else if (ctx.INT() != null) {
            return new IntLiteral(ctx.INT().getSymbol());
        } else if (ctx.DOUBLE() != null) {
            return new DoubleLiteral(ctx.DOUBLE().getSymbol());
        } else if (ctx.STRING() != null) {
            return new StringLiteral(ctx.STRING().getSymbol());
        } else if (ctx.NULL() != null) {
            return new NullLiteral(ctx.NULL().getSymbol());
        }
        throw new RuntimeException(String.format("Unknown literal %s", ctx.getText()));
    }

    @Override
    public VariableExpression visitVar(CcoolParser.VarContext ctx) {
        return new VariableExpression(ctx.ID().getSymbol());
    }
}
