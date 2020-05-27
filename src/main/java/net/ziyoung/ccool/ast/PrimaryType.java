package net.ziyoung.ccool.ast;

public class PrimaryType extends Symbol implements Type {
    private final int typeIndex;
    private final String typeName;

    public PrimaryType(int typeIndex, String typeName) {
        super(typeName);
        this.typeIndex = typeIndex;
        this.typeName = typeName;
    }

    @Override
    public String getName() {
        return typeName;
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
