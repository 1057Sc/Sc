package java8.sfuction;

import org.junit.Test;
import reflect.Student;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author Sc
 * @date 2021/3/16
 */
public class SFunctionTest {

    @Test
    public void test1() throws NoSuchMethodException {
        Function<String, String> s1 = String::trim;
        Class<? extends Function> aClass = s1.getClass();
        Field[] fields = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();
        Method[] declaredMethods = aClass.getDeclaredMethods();

        Method writeReplace = aClass.getDeclaredMethod("writeReplace");
        System.out.println(aClass);
    }


    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SFunction<Student, String> s1 = Student::getName;

        Class<? extends Function> aClass = s1.getClass();
        Field[] fields = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();
        Method[] declaredMethods = aClass.getDeclaredMethods();

        Method writeReplace = aClass.getDeclaredMethod("writeReplace");
        writeReplace.setAccessible(true);
        SerializedLambda serializedLambda = (SerializedLambda) writeReplace.invoke(s1);
        String getter = serializedLambda.getImplMethodName();
        String implClass = serializedLambda.getImplClass();
        // String implMethodName = serializedLambda.he();
        System.out.println(aClass);
    }

    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SFunction<String, List<Student>> fun1 = (s) -> Collections.singletonList(new Student());
        Class<? extends SFunction> aClass = fun1.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Method method = fun1.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        SerializedLambda invoke = (SerializedLambda) method.invoke(fun1);
        String implMethodSignature = invoke.getImplMethodSignature();
        String functionalInterfaceClass = invoke.getFunctionalInterfaceClass();
        String functionalInterfaceMethodSignature = invoke.getFunctionalInterfaceMethodSignature();
        String getter = invoke.getImplMethodName();
        String implClass = invoke.getImplClass();
        func(fun1);
    }


    private <R> void func(SFunction<String, List<R>> func) {
        try {
            Class<? extends SFunction> aClass = func.getClass();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Method method = func.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            SerializedLambda invoke = (SerializedLambda) method.invoke(func);
            String getter = invoke.getImplMethodName();
            String implClass = invoke.getImplClass();
            System.out.println(123213);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
