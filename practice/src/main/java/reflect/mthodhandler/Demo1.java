package reflect.mthodhandler;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Demo1 {

    public void demo2() throws Throwable {
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // Method Handle for Methods
        MethodType mt = MethodType.methodType(String.class, String.class);
        MethodHandle concatMH = publicLookup.findVirtual(String.class, "concat", mt);

        // Method Handle for Static Methods
        MethodType mt1= MethodType.methodType(List.class, Object[].class);
        MethodHandle asListMH = publicLookup.findStatic(Arrays.class, "asList", mt1);

        // Method Handle for Constructors
        MethodType mt2 = MethodType.methodType(void.class, String.class);
        MethodHandle newIntegerMH = publicLookup.findConstructor(Integer.class, mt2);

        // Invoking a Method Handle
        MethodType mt3 = MethodType.methodType(String.class, char.class, char.class);
        MethodHandle replaceMH = publicLookup.findVirtual(String.class, "replace", mt);
        String output = (String) replaceMH.invoke("codemao", Character.valueOf('o'), 'a');
        assertEquals("codemao", output);
    }
}
