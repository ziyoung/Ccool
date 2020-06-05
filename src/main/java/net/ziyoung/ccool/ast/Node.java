package net.ziyoung.ccool.ast;

public interface Node {
    default <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNode(this, context);
    }
}
