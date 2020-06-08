package net.ziyoung.ccool.parser;

import net.ziyoung.ccool.antlr.CcoolBaseVisitor;
import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.type.TypeName;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class AstBuilder extends CcoolBaseVisitor<Node> {
    private final ExpressionFactory factory;

    public AstBuilder() {
        this.factory = new ExpressionFactory(this);
    }

    @Override
    public CompilationUnit visitCompilationUnit(CcoolParser.CompilationUnitContext ctx) {
        List<ClassDeclaration> declarations = new ArrayList<>();
        for (CcoolParser.ClassDefinitionContext classDefinitionContext : ctx.classDefinition()) {
            ClassDeclaration declaration = visitClassDefinition(classDefinitionContext);
            declarations.add(declaration);
        }
        // Right now packageName is empty.
        return new CompilationUnit("", declarations);
    }

    @Override
    public ClassDeclaration visitClassDefinition(CcoolParser.ClassDefinitionContext ctx) {
        Token token = ctx.CLASSID().getSymbol();
        List<Statement> statements = new ArrayList<>();
        for (CcoolParser.ClassMemberContext classMemberContext : ctx.classMember()) {
            Statement declaration = null;
            if (classMemberContext.varDeclaration() != null) {
                CcoolParser.VarDeclarationContext context = classMemberContext.varDeclaration();
                declaration = visitVarDeclaration(context);
            } else if (classMemberContext.methodDeclaration() != null) {
                CcoolParser.MethodDeclarationContext context = classMemberContext.methodDeclaration();
                declaration = visitMethodDeclaration(context);
            }
            if (declaration != null) {
                statements.add(declaration);
            }
        }
        return new ClassDeclaration(token, statements);
    }

    @Override
    public MethodDeclaration visitMethodDeclaration(CcoolParser.MethodDeclarationContext ctx) {
        Token token = ctx.ID().getSymbol();
        TypeName typeName = Types.typeContextToTypeName(ctx.type());
        List<Parameter> parameters = new ArrayList<>();
        CcoolParser.FormalParametersContext parametersContext = ctx.formalParameters();
        if (parametersContext != null) {
            for (int index = 0; index < parametersContext.type().size(); index++) {
                CcoolParser.TypeContext typeContext = parametersContext.type(index);
                TypeName typeName1 = Types.typeContextToTypeName(typeContext);
                Token token1 = parametersContext.ID(index).getSymbol();
                Parameter parameter = new Parameter(token1, typeName1);
                parameters.add(parameter);
            }
        }
        BlockStatement blockStatement = visitBlock(ctx.block());
        return new MethodDeclaration(typeName, token, parameters, blockStatement);
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
        fallback(ctx);
        return null;
    }

    @Override
    public VariableDeclaration visitVarDeclaration(CcoolParser.VarDeclarationContext ctx) {
        TypeName typeName = Types.typeContextToTypeName(ctx.type());
        Token token = ctx.ID().getSymbol();
        Expression expression = null;
        CcoolParser.ExpressionContext expressionContext = ctx.expression();
        if (expressionContext != null) {
            expression = (Expression) visit(expressionContext);
        }
        return new VariableDeclaration(typeName, token, expression);
    }

    @Override
    public CallExpression visitCall(CcoolParser.CallContext ctx) {
        // FIXME: support class method call link new A().fn()
        Token token = ctx.ID().getSymbol();
        Expression function = new VariableExpression(token);
        List<Expression> arguments = new ArrayList<>();
        CcoolParser.ExpressionListContext listContext = ctx.expressionList();
        if (listContext != null) {
            for (CcoolParser.ExpressionContext expressionContext : listContext.expression()) {
                Expression expression = (Expression) visit(expressionContext);
                arguments.add(expression);
            }
        }
        return new CallExpression(token, function, arguments);
    }

    @Override
    public BinaryExpression visitMultiply(CcoolParser.MultiplyContext ctx) {
        return factory.getBinaryExpression(ctx.start, ctx.expression(0), ctx.expression(1), "*");
    }

    @Override
    public BinaryExpression visitDivision(CcoolParser.DivisionContext ctx) {
        return factory.getBinaryExpression(ctx.start, ctx.expression(0), ctx.expression(1), "/");
    }

    @Override
    public BinaryExpression visitAdd(CcoolParser.AddContext ctx) {
        return factory.getBinaryExpression(ctx.start, ctx.expression(0), ctx.expression(1), "+");
    }

    @Override
    public BinaryExpression visitMinus(CcoolParser.MinusContext ctx) {
        return factory.getBinaryExpression(ctx.start, ctx.expression(0), ctx.expression(1), "-");
    }

    @Override
    public BinaryExpression visitAssign(CcoolParser.AssignContext ctx) {
        return factory.getBinaryExpression(ctx.start, ctx.expression(0), ctx.expression(1), "=");
    }

    @Override
    public UnaryExpression visitNegative(CcoolParser.NegativeContext ctx) {
        return factory.getUnaryExpression(ctx.start, ctx.expression(), "-");
    }

    @Override
    public UnaryExpression visitGroup(CcoolParser.GroupContext ctx) {
        return factory.getUnaryExpression(ctx.start, ctx.expression(), "()");
    }

    @Override
    public VariableExpression visitVar(CcoolParser.VarContext ctx) {
        return new VariableExpression(ctx.ID().getSymbol());
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
        fallback(ctx);
        return null;
    }

    private void fallback(ParserRuleContext context) {
        throw new RuntimeException(String.format("Unknown literal %s", context.getText()));
    }
}
