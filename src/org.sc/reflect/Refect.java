package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Sc on 2018/6/12.
 */
public class Refect {

    //1获取Class对象
    static Class clazz;

    static {
        try {
             clazz = Class.forName("reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //field();
        method();
    }

    public static void field() throws Exception{

        System.out.println(clazz);

        /**
         *  -------------------------------------------------------------------------------------------------
         *                             字段操作
         */

        //2,获取字段
        Field[] fields = clazz.getFields();
        for(Field f: fields){
            System.out.println("共有字段"+f);
        }
        //所有字段
        Field[] fieldsAll = clazz.getDeclaredFields();
        for (Field f:fieldsAll){
            System.out.println(f);
        }

        //获取public的字段名
        Field field = clazz.getField("phone");
        System.out.println("获取public的字段名"+field);
        //产生一个Student的对象
        Object obj = clazz.getConstructor().newInstance();
        field.set(obj,"17611251996");
        Student student = (Student)obj;
        System.out.println(student.phone);

        //获取private的字段名
        Field field1 = clazz.getDeclaredField("name");
        System.out.println("获取private的字段名"+field1);
        field1.setAccessible(true);
        field1.set(obj,"Sc");
        System.out.println("private-field---"+student.getName());
    }

    public static void constructor(){
        /**
         *  -------------------------------------------------------------------------------------------------
         *                                  构造器操作
         */
        //所有公有的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }
        //所有的构造器 private public default protected
        Constructor[] constructorsAll = clazz.getDeclaredConstructors();
        for (Constructor c : constructorsAll){
            System.out.println(c);
        }

    }

    public static void method() throws Exception {
        /**
         *  -------------------------------------------------------------------------------------------------
         *                                  成员方法操作
         */
        //获取public的成员方法
        Method[] methods = clazz.getMethods();
        for (Method m: methods){
            System.out.println("public的成员方法"+m);

        }
        //获取 public private default protected 的 methods
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods){
            System.out.println("public private default protected 的 methods"+m);
        }

        Method method = clazz.getMethod("method",int.class,String.class);
        Object obj = clazz.getConstructor().newInstance();
        Student student = (Student)obj;
        method.invoke(student,123,"Sc");
    }
}
