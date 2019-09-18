package collection.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sc on 6/10/2019.
 */
public class StreamDemo {

    public static void main(String[] args) {
        Demo1();
    }

    public static void Demo1(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.stream().mapToInt(Integer::byteValue).sum());


    }

    public static void Demo2(){
        List<String> list = Arrays.asList();
    }
}
