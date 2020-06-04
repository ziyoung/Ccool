package net.ziyoung.ccool.type;

import net.ziyoung.ccool.antlr.CcoolParser;

import java.util.Map;

public class Types {
    public static final int tInvalid = -1;
    public static final int tUser = 0;
    public static final int tBool = 1;
    public static final int tInt = 2;
    public static final int tDouble = 3;
    public static final int tString = 4;
    public static final int tVoid = 5;

    public static final PrimaryType _invalid = new PrimaryType(tInvalid, "invalid");
    public static final PrimaryType _bool = new PrimaryType(tBool, "bool");
    public static final PrimaryType _int = new PrimaryType(tInt, "int");
    public static final PrimaryType _double = new PrimaryType(tDouble, "double");
    public static final PrimaryType _string = new PrimaryType(tString, "string");
    public static final PrimaryType _void = new PrimaryType(tVoid, "void");

    public static final PrimaryType[] primaryTypes = {
            _bool, _int, _double, _string, _void
    };

    private static final Map<Integer, String> typeDescriptorMap = Map.of(
            tUser, "Ljava/lang/Object;",
            tBool, "B",
            tInt, "I",
            tDouble, "D",
            tString, "Ljava/lang/String;",
            tVoid, "V"
    );

    public static PrimaryType[] getPrimaryTypes() {
        return primaryTypes;
    }

    public static Type createUserDefinedType(String name) {
        return new Type(tUser, name);
    }

    public static TypeName typeContextToTypeName(CcoolParser.TypeContext context) {
        return new TypeName(context.getStart());
    }

    public static String getTypeDescriptor(Type type) {
        int index = type.getIndex();
        if (typeDescriptorMap.containsKey(index)) {
            return typeDescriptorMap.get(index);
        }
        throw new RuntimeException(String.format("unsupported type %s", type.getName()));
    }

    public static boolean isInvalidType(Type type) {
        return _invalid.equals(type);
    }

    public static boolean isIntType(Type type) {
        return _int.equals(type);
    }

    public static boolean isStringType(Type type) {
        return _string.equals(type);
    }
}
