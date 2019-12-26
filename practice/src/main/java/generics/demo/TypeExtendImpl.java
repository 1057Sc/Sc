package generics.demo;

public abstract class TypeExtendImpl<T, C extends T> implements TypeExtend<T, C >{

    @Override
    public T getEntity(C entity) {
        return null;
    }

    @Override
    public <E extends T> T getE(E e) {
        return null;
    }
}
