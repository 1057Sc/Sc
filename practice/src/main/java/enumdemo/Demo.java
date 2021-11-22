package enumdemo;

import org.junit.Test;

public class Demo {

    @Test
    public void demo() {
        EnumCode demo1 = EnumCode.demo1;
        System.out.println(demo1);
        EnumCode demo2 = EnumCode.demo1;
        demo2.setCode(111);
        System.out.println(demo2);
        System.out.println(EnumCode.demo1);
    }
}
