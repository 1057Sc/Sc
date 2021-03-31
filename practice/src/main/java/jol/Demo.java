package jol;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;

/**
 * @author zhuqingxin
 * @date 2021/3/31
 */
public class Demo {

    @Test
    public void demo(){
        System.out.println(ClassLayout.parseClass(ArrayList.class).toPrintable());
    }


}
