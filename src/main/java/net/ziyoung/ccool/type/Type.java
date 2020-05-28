package net.ziyoung.ccool.type;

public interface Type {
    public String getName();

    public int getTypeIndex();

    // FIXME: canAssignTo needs to be implemented.
    default public boolean canAssignTo(Type destType) {
        return false;
    };
}