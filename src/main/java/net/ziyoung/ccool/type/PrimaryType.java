package net.ziyoung.ccool.type;

public class PrimaryType extends Type {
    protected PrimaryType(int index, String name) {
        super(index, name);
    }

    @Override
    public boolean canAssignTo(Type destType) {
        return this == destType;
    }
}
