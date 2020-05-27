package net.ziyoung.ccool.ast;

public class UserDefinedType implements Type {
    private final String typeName;

    public UserDefinedType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String getName() {
        return typeName;
    }

    @Override
    public int getTypeIndex() {
        return SymbolTable.tUser;
    }
}
