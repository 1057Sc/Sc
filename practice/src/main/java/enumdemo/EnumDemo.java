package enumdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
/**
 * Created by Sc on 5/14/2019.
 */
public class EnumDemo {

    public enum Sex
    {
        //定义一个枚举
        male("1","2"),
        female("3","4");
        Sex(String a,String b){
            System.out.println(a+":::"+b);
        }
    }
    public static void main(String[] args)
    {

        Sex sex = Sex.valueOf("112");
        compare(Sex.valueOf("male"));    //比较
        System.out.println();

    }
    public static void compare(Sex s)
    {
        for(int i=0;i<Sex.values().length;i++)
        {
            System.out.println(s+"与"+Sex.values()[i]+"的比较结果是："+s.compareTo(Sex.values()[i]));
        }
    }

}
