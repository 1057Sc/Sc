package java8.sfuction;

import org.junit.Test;
import reflect.Student;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * @author zhuqingxin
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
}
