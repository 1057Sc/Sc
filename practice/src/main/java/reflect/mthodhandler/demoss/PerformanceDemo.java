package reflect.mthodhandler.demoss;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class PerformanceDemo {

    public static void main(String[] args) throws Throwable {
        PerformanceTest testInstance = new PerformanceTest();
        Method test = PerformanceTest.class.getDeclaredMethod("test", String.class);

        int num = 100_000_000;

        long reflectStart = System.currentTimeMillis();
        System.out.println("reflect start");
        for (int i = 0; i < num; i++) {
            test.invoke(testInstance, "codemao");
        }
        System.out.println(System.currentTimeMillis() - reflectStart);

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(PerformanceTest.class, "test", MethodType.methodType(void.class, String.class));

        long mhStart = System.currentTimeMillis();
        System.out.println("MethodHandle start");
        for (int i = 0; i < num; i++) {
            mh.invoke(testInstance, "codemao");
        }
        System.out.println(System.currentTimeMillis() - mhStart);

        long invokeDirectly = System.currentTimeMillis();
        System.out.println("invokeDirectly start");
        for (int i = 0; i < num; i++) {
            testInstance.test("codemao");
        }
        System.out.println(System.currentTimeMillis() - invokeDirectly);
    }

}

class PerformanceTest {
    String name;

    public void test(String name) {
        this.name = name;
    }
}