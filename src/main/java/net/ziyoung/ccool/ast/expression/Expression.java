package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.AstVisitor;
import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.type.Type;

public interface Expression extends Node {
    public Type getType();

    @Override
    default public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitExpression(this, context);
    }
}
