package net.ziyoung.ccool.type;

public class TypeReference extends Type {
    private final String typeName;

    public TypeReference(String name) {
        super(name);
        typeName = name;
    }

    @Override
    public String getName() {
        return typeName;
    }

    @Override
    public int getTypeIndex() {
        return Types.tUser;
    }
}
