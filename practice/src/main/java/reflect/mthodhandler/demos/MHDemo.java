package reflect.mthodhandler.demos;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * a simple example of method handle creation and invocation
 */
public class MHDemo {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findStatic(MHDemo.class, "hello", MethodType.methodType(void.class));
        mh.invokeExact();
    }

    public static void hello() {
        System.out.println("hello code mao");
    }
}
