package reflect.office.proxy;

public class FooImpl implements Foo {
    @Override
    public Object bar(Object obj) throws Exception {
        System.out.println("bar bar bar");
        return obj;
    }
}
