package org.sc.hutool.practice.img;

import cn.hutool.core.util.ReflectUtil;
import org.junit.Test;
import sun.security.pkcs11.Secmod;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class ReflectUtils {

    @Test
    public void demo1() {
        TestObj testObj = new TestObj("zqx", "99");
        Field namefield = ReflectUtil.getField(TestObj.class, "name");
        Object fieldValue = ReflectUtil.getFieldValue(testObj, namefield);
        System.out.println(fieldValue);
    }

    @Test
    public void demo2() throws Throwable {
        TestObj testObj = new TestObj("zqx", "99");
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
      /*  MethodHandle name = publicLookup.findGetter(TestObj.class, "getName", MethodType.methodType(String.class));
        Object invoke = name.invokeExact(testObj);
        System.out.println(invoke.toString());*/

        MethodHandle getterMethodHandle = lookup.findVirtual(TestObj.class,
                "getName", MethodType.methodType(String.class));

        System.out.println(getterMethodHandle.invoke(testObj));

        // if you use this method , you much use correct result type
        // Method java/lang/invoke/MethodHandle.invokeExact:(Lorg/sc/hutool/practice/img/TestObj;)Ljava/lang/String;
        String s = (String) getterMethodHandle.invokeExact(testObj);
        System.out.println(s);
    }


    public <T> void demo3(T t) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle getterMethodHandle = lookup.findVirtual(t.getClass(), "getName", MethodType.methodType(String.class));
        System.out.println(getterMethodHandle.invoke(t));
        // todo resolve it
        // System.out.println((String) getterMethodHandle.invokeExact(t));

        MethodHandle getterMethodHandle2 = lookup.findVirtual(TestObj.class, "getName", MethodType.methodType(String.class));
        System.out.println("getterMethodHandle2------------------------" + getterMethodHandle2.invoke(t));
        // Method java/lang/invoke/MethodHandle.invokeExact:(Ljava/lang/Object;)Ljava/lang/Object;
        // todo can't user generic parameter
        System.out.println("getterMethodHandle2" + getterMethodHandle2.invokeExact(t));
    }

    public static void main(String[] args) throws Throwable {
        ReflectUtils reflectUtils = new ReflectUtils();
        TestObj testObj = new TestObj("zqx", "99");
        reflectUtils.demo3(testObj);
    }
}
