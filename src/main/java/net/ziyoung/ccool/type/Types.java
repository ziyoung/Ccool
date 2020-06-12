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
            tBool, "Z",
            tInt, "I",
            tDouble, "D",
            tString, "Ljava/lang/String;",
            tVoid, "V"
    );

    public static final Type[][] arithmeticResultTypes = new Type[][]{
            /*          class   bool   int   double  string void    */
            /*class*/   {_void, _void, _void, _void, _void, _void},
            /*bool*/    {_void, _void, _void, _void, _void, _void},
            /*int*/     {_void, _void, _int, _double, _string, _void},
            /*double*/  {_void, _void, _double, _double, _string, _void},
            /*string*/  {_void, _void, _string, _string, _string, _void},
            /*void*/    {_void, _void, _void, _void, _void, _void},
    };

    public static final Type[][] promoteResultTypes = new Type[][]{
            /*          class  bool  int  double string void */
            /*class*/   {null, null, null, null, null, null},
            /*bool*/    {null, null, null, null, null, null},
            /*int*/     {null, null, null, _double, null, null},
            /*double*/  {null, null, null, null, null, null},
            /*string*/  {null, null, null, null, null, null},
            /*void*/    {null, null, null, null, null, null},
    };

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

    public static int getTypeSize(Type type) {
        // In pre-analyse and analyse phase, type can be null.
        return type == null ? 1 : type.getSlotSize();
    }
}
