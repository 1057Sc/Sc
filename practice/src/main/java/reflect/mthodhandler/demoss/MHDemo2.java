package reflect.mthodhandler.demoss;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

public class MHDemo2 {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // entity 转 vo
        Foo foo = new Foo();
        FooVO fooVO = new FooVO();
        Field[] entityFields = foo.getClass().getDeclaredFields();
        for (Field entityField : entityFields) {
            entityField.setAccessible(true);
            MethodHandle methodHandle = lookup.unreflectGetter(entityField);
            Object invoke = methodHandle.invoke(foo);

            // 此处需要考虑属性不存在的情况 此处只是demo 简单演示
            Field voField = fooVO.getClass().getDeclaredField(entityField.getName());
            voField.setAccessible(true);
            MethodHandle voMethodHandle = lookup.unreflectSetter(voField);
            voMethodHandle.invoke(fooVO, invoke);
        }
        System.out.println(fooVO.getAge() + ":::" + fooVO.getName());
    }
}

class FooVO {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Foo {
    private String name = "codemao";
    private int age = 6;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
