package reflect.mthodhandler.demos;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * an example that demonstrates trying to obtain a method handle to an inaccessible target
 */
public class MHDemo1 {

    public static void main(String[] args) throws Throwable {
        HelloWorld helloWorld = new HelloWorld();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(HelloWorld.class, "hello1", MethodType.methodType(void.class));
        mh.invoke(helloWorld);

        // MethodHandle invoke private 方法时需要通过以下的方式
        Method hello2 = HelloWorld.class.getDeclaredMethod("hello2");
        hello2.setAccessible(true);
        mh = lookup.unreflect(hello2);
        mh.invoke(helloWorld);
    }
}

class HelloWorld {
    public void hello1() {
        System.out.println("hello codemao public");
    }

    private void hello2() {
        System.out.println("hello codemao private");
    }
}