package net.ziyoung.ccool.type;

import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.error.SemanticErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeChecker {
    private static final Logger logger = LoggerFactory.getLogger(TypeChecker.class);

    public static Type getResultType(Type[][] typeTable, Expression a, Expression b) {
        int ta = a.getType().getIndex();
        int tb = b.getType().getIndex();
        Type result = typeTable[ta][tb];
        if (result == Types._void) {
            SemanticErrors.error(a.getToken(), String.format("%s:<%s>, %s:<%s> have incompatible type", a.getToken().getText(), a.getType(), b.getToken().getText(), b.getType()));
        } else {
            Type[][] promoteTypes = Types.promoteResultTypes;
            a.setPromoteType(promoteTypes[ta][tb]);
            b.setPromoteType(promoteTypes[tb][ta]);
        }
        return result;
    }

    public static Type binaryOp(Expression a, Expression b) {
        return getResultType(Types.arithmeticResultTypes, a, b);
    }

    public static Type negativeOp(Expression a) {
        Type type = a.getType();
        if (!(type != null && type.isNumber())) {
            SemanticErrors.errorUnmatchedType(a.getToken(), type, Types._int, Types._double);
        }
        return type;
    }

    public static Type assignOp(Expression lhs, Expression rhs) {
        int tlhs = lhs.getType().getIndex();
        int trhs = lhs.getType().getIndex();
        rhs.setPromoteType(Types.promoteResultTypes[tlhs][trhs]);
        if (!canAssignTo(rhs.getType(), lhs.getType(), rhs.getPromoteType())) {
            SemanticErrors.errorUnmatchedType(lhs.getToken(), rhs.getType(), lhs.getType());
        }
        return lhs.getType();
    }

    private static boolean canAssignTo(Type valueType, Type destType, Type promotion) {
        return destType != null && (destType == valueType || destType == promotion);
    }
}
