package net.ziyoung.ccool.type;

public class TypeReference implements Type {
    private final String name;

    public TypeReference(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTypeIndex() {
        return Types.tUser;
    }
}
