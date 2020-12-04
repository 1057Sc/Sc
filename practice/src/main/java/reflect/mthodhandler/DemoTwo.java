package reflect.mthodhandler;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 *
 * @Description :
 * For creating and using a MethodHandle, 4 steps are required:
 * Creating the lookup
 * Creating the method type
 * Finding the method handle
 * Invoking the method handle
 */
public class DemoTwo {

    @Test
    public void demo1() throws Throwable {
        //create the lookup that provides access to public methods:
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();

        // in case we want to have access also to private and protected methods, we can use, instead, the lookup() method:
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // define a MethodType that specifies a java.util.List class as return type and an Object array as input type
        MethodType mt = MethodType.methodType(List.class, Object[].class);

        // primitive type :define a MethodType that returns an int value and accepts an Object:
        MethodType mt1 = MethodType.methodType(int.class, Object.class);

        //
        MethodType mt2 = MethodType.methodType(String.class, String.class);
        MethodHandle concatMH = publicLookup.findVirtual(String.class, "concat", mt2);


        // handle
        MethodType mt3 = MethodType.methodType(String.class, char.class, char.class);
        MethodHandle replaceMH = publicLookup.findVirtual(String.class, "replace", mt3);
        String output = (String) replaceMH.invoke("jovo", 'o', 'a');
        assertEquals("java", output);
        System.out.println(output);
    }

    /**
     * Invoking with Arguments
     */
    @Test
    public void demo2() throws Throwable {
        //create the lookup that provides access to public methods:
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();

        MethodType mt = MethodType.methodType(List.class, Object[].class);
        MethodHandle asList = publicLookup.findStatic(Arrays.class, "asList", mt);

        List<Integer> list = (List<Integer>) asList.invokeWithArguments(1,2);

        System.out.println(list);
    }

    @Test
    public void demo3() throws Throwable {

        // in case we want to have access also to private and protected methods, we can use, instead, the lookup() method:
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle sumMH = lookup.findStatic(Integer.class, "sum", mt);

        int sum = (int) sumMH.invokeExact(1, 11);
        System.out.println(sum);
    }

    @Test
    public void demo4() throws Throwable {
        //create the lookup that provides access to public methods:
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodType mt = MethodType.methodType(boolean.class, Object.class);
        MethodHandle equals = publicLookup.findVirtual(String.class, "equals", mt);
        MethodHandle methodHandle = equals.asSpreader(Object[].class, 2);
        System.out.println((boolean) methodHandle.invoke(new Object[] { "java", "java" }));
    }

}
