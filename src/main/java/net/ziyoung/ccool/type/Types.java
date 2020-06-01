package net.ziyoung.ccool.type;

import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.ast.statement.ClassDeclaration;
import org.antlr.v4.runtime.Token;

import java.util.Map;

public class Types {
    public static final int tInvalid = -1;
    public static final int tUser = 0;
    public static final int tBool = 1;
    public static final int tInt = 2;
    public static final int tDouble = 3;
    public static final int tString = 4;
    public static final int tVoid = 5;

    public static final PrimaryType _bool = new PrimaryType(tBool, "bool");
    public static final PrimaryType _int = new PrimaryType(tInt, "int");
    public static final PrimaryType _double = new PrimaryType(tDouble, "double");
    public static final PrimaryType _string = new PrimaryType(tString, "string");
    public static final PrimaryType _void = new PrimaryType(tVoid, "void");

    public static final PrimaryType[] primaryTypes = {
            _bool, _int, _double, _string, _void
    };

    public static final Map<String, PrimaryType> primaryTypeMap = Map.of(
            "bool", _bool,
            "int", _int,
            "double", _double,
            "string", _string,
            "void", _void
    );

//    public static final Map<String, Type> typeReferenceMap = new LinkedHashMap<>();

    public static PrimaryType[] getPrimaryTypes() {
        return primaryTypes;
    }

    public static Type createUserDefinedType(String name) {
        return new Type(tUser, name);
    }

    public static TypeName typeContextToTypeName(CcoolParser.TypeContext context) {
        return new TypeName(context.getStart());
    }

    public static boolean isIntType(Type type) {
        return _int.equals(type);
    }
}
