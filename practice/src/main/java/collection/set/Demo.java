package collection.set;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/**
 * Created by Sc on 6/29/2019.
 */
public class Demo {

    public static void main(String[] args) {
        demo1();
        Short s = 1;
        Integer i = 1;
        testGenericMethodDefine(s, i);
    }

    public static void demo1() {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(7);

        System.out.println(set);


    }

    public static <T, S extends T> T testGenericMethodDefine(T t, S s){

        return t;
    }

}
