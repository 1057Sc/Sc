package reflect.office.proxy;

public class TestMain {

    public static void main(String[] args) throws Exception {
        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
        foo.bar(null);
    }
}
