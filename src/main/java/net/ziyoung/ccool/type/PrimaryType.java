package net.ziyoung.ccool.type;

public class PrimaryType extends Type {
    private final int typeIndex;

    public PrimaryType(int typeIndex, String typeName) {
        super(typeName);
        this.typeIndex = typeIndex;
    }

    @Override
    public int getTypeIndex() {
        return typeIndex;
    }

    @Override
    public boolean canAssignTo(Type destType) {
        return this == destType;
    }
}
