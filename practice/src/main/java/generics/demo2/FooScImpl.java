package generics.demo2;

import generics.Foo;
import reflect.Student;
import reflect.invoke.FooImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class FooScImpl implements FooSc<Student> {

    public static void main(String[] args) {
       /* FooScImpl fooSc = new FooScImpl();
        Class<? extends FooScImpl> aClass = fooSc.getClass();
        Class<?>[] interfaces = fooSc.getClass().getInterfaces();
        Type[] genericInterfaces = aClass.getGenericInterfaces();


        for (Type genericInterface : genericInterfaces) {
            String typeName = genericInterface.getTypeName();
            System.out.println(typeName);
        }
        System.out.println(1);*/
       demo2();
        foo1(new FooScImpl());
    }


    public static void demo2(){
        Class clazz = FooScImpl.class;
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            FooSc.class.getName().equals(rawType.getTypeName());
            FooSc.class.getName().equals(type.getTypeName());
            for (Type actualTypeArgument : parameterizedType.getActualTypeArguments()) {

                Class actualTypeArgument1 = (Class) actualTypeArgument;
                System.out.println(actualTypeArgument1.getSimpleName());
                System.out.println(actualTypeArgument.getTypeName());
            }
        }

    }

    public static void demo1(){

        //获取子类字节码文件对象，this代表的是子类对象。
        Class clazz = FooScImpl.class;

        //获取子类所属接口的参数化类型,cn.xxx.xxx.BasicAction<cn.xxx.xxx.Standard>
        Type type = clazz.getGenericSuperclass();

        //因为type是顶级接口没有定义任何方法，所以需要强转为子接口ParameterizedType
        ParameterizedType parameterizedType = (ParameterizedType) type;

        //通过子接口定义的getActualTypeArguments方法获取到实际参数类型,<cn.xxx.xxx.Standard>
        //返回参数为数组，因为Java中接口可以多实现
        Type[] types = parameterizedType.getActualTypeArguments();

        //获取数组中的实际参数类型
        Class clzz = (Class) types[0];

        //通过实际参数类型获取实际参数类型的实例
    }


    public static void foo1(FooSc fooSc){
        Class<? extends FooSc> aClass = fooSc.getClass();
        System.out.println(Arrays.toString(aClass.getClasses()));
    }

}
