package reflect.mthodhandler.demos;

import java.lang.invoke.*;

/**
 * an example of a bootstrap method
 */
public class BSDemo {

    private static MethodHandle hw;

    private static void hw() {
        System.out.println("Hello, World!");
    }

    public static CallSite bootstrapDynamic() throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class thisClass = lookup.lookupClass();
        hw = lookup.findStatic(thisClass, "hw", MethodType.methodType(void.class));
        return new ConstantCallSite(hw);
    }

    public static void main(String[] args) throws Throwable {
        CallSite callSite = bootstrapDynamic();
        callSite.dynamicInvoker().invoke();
    }
}
