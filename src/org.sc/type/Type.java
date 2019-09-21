package type;

public interface Type<T, C extends T> {

    T getEntity(C entity);

    <E extends T> T getE(E e);
}
