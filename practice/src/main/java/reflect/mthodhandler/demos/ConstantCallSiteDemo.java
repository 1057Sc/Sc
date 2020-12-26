package reflect.mthodhandler.demos;

import java.lang.invoke.*;

public class ConstantCallSiteDemo {

    private static MethodHandle hw;

    private static void hw() {
        System.out.println("Hello, codemao!");
    }

    public static CallSite bootstrapDynamic(MethodHandles.Lookup caller,
                                            String name,
                                            MethodType type)
            throws IllegalAccessException, NoSuchMethodException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class thisClass = lookup.lookupClass();
        hw = lookup.findStatic(thisClass, "hw", MethodType.methodType(void.class));
        if (!type.equals(hw.type())) {
            hw = hw.asType(type);
        }

        return new ConstantCallSite(hw);
    }

    public static void main(String[] args) throws Throwable {
        CallSite callSite = bootstrapDynamic(null, null, MethodType.methodType(void.class));
        MethodHandle methodHandle = callSite.dynamicInvoker();
        methodHandle.invoke();
    }
}
