package conditionalStatment.todowhile;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

public class Demo {


    @Test
    public void demo1(){

        int i = 10;

        do {
            System.out.println(i);
            i--;
        }while (i > 10);
    }

    @Test
    public void demo2(){
        String s = "DSDDS_asdasd";
        System.out.println(StrUtil.toCamelCase(s));
    }
}
