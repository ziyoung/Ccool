package net.ziyoung.ccool.ast.expression;

import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

/**
 * If an expression is encountered, a value is created and push on the operand stack.
 * So every expression has type.
 */
public abstract class Expression implements Node {
    private final Token token;
    private Type type;
    private Type promoteType;

    public Expression(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getPromoteType() {
        return promoteType;
    }

    public void setPromoteType(Type promoteType) {
        this.promoteType = promoteType;
    }
}
