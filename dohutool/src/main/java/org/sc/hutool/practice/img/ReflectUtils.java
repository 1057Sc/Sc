package org.sc.hutool.practice.img;

import cn.hutool.core.util.ReflectUtil;
import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectUtils {

    @Test
    public void demo1(){
        TestObj testObj = new TestObj("zqx","99");
        Field namefield = ReflectUtil.getField(TestObj.class, "name");
        Object fieldValue = ReflectUtil.getFieldValue(testObj, namefield);
        System.out.println(fieldValue);
    }
}
