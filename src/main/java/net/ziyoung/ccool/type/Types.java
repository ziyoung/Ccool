package net.ziyoung.ccool.type;

import net.ziyoung.ccool.antlr.CcoolParser;

import java.util.LinkedHashMap;
import java.util.Map;

public class Types {
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

    public static final Map<String, TypeReference> typeReferenceMap = new LinkedHashMap<>();

    public static Type textToType(String text) {
        if (primaryTypeMap.containsKey(text)) {
            return primaryTypeMap.get(text);
        }
        if (typeReferenceMap.containsKey(text)) {
            return typeReferenceMap.get(text);
        }
        TypeReference typeReference = new TypeReference(text);
        typeReferenceMap.put(text, typeReference);
        return typeReference;
    }

    public static Type typeContextToType(CcoolParser.TypeContext context) {
        return textToType(context.getText());
    }

    public static boolean isIntType(Type type) {
        return _int.equals(type);
    }
}
