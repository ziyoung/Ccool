package net.ziyoung.ccool.type;

import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.error.SemanticErrors;

public class TypeChecker {
    public static Type getResultType(Type[][] typeTable, Expression a, Expression b) {
        int ta = a.getType().getIndex();
        int tb = a.getType().getIndex();
        Type result = typeTable[ta][tb];
        if (result == Types._void) {
            SemanticErrors.error(a.getToken(), String.format("%s:<%s>, %s:<%s> have incompatible type", a.getToken().getText(), a.getType(), b.getToken().getText(), b.getType()));
        } else {
            Type[][] promoteTypes = Types.promoteTypes;
            a.setPromoteType(promoteTypes[ta][tb]);
            b.setPromoteType(promoteTypes[tb][ta]);
        }
        return result;
    }

    public static Type binaryOp(Expression a, Expression b) {
        return getResultType(Types.arithmeticResultTypes, a, b);
    }
}
