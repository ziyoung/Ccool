package net.ziyoung.ccool.parser;

import net.ziyoung.ccool.antlr.CcoolBaseVisitor;
import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.arithmetic.AddExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.DivisionExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.MinusExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.MultiplyExpression;
import org.antlr.v4.runtime.Token;

public class ExpressionFactory {
    private final CcoolBaseVisitor<Node> visitor;

    public ExpressionFactory(CcoolBaseVisitor<Node> visitor) {
        this.visitor = visitor;
    }

    public BinaryExpression getBinaryExpression(Token start, CcoolParser.ExpressionContext lhsContext, CcoolParser.ExpressionContext rhsContext, String operator) {
        Expression lhs = (Expression) visitor.visit(lhsContext);
        Expression rhs = (Expression) visitor.visit(rhsContext);
        switch (operator) {
            case "*":
                return new MultiplyExpression(start, lhs, rhs);
            case "/":
                return new DivisionExpression(start, lhs, rhs);
            case "+":
                return new AddExpression(start, lhs, rhs);
            case "-":
                return new MinusExpression(start, lhs, rhs);
            case "=":
                return new AssignExpression(start, lhs, rhs);
            default:
                throw new RuntimeException(String.format("unknown operator %s for binary expression", operator));
        }
    }

    public UnaryExpression getUnaryExpression(Token start, CcoolParser.ExpressionContext rhsContext, String operator) {
        Expression rhs = (Expression) visitor.visit(rhsContext);
        switch (operator) {
            case "-":
                return new NegativeExpression(start, rhs);
            case "()":
                return new GroupExpression(start, rhs);
            default:
                throw new RuntimeException(String.format("unknown operator %s for unary expression", operator));
        }
    }
}
