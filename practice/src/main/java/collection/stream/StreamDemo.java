package collection.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sc on 6/10/2019.
 */
public class StreamDemo {

    public static void main(String[] args) {
        Demo1();
    }

    public static void Demo1() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);


        System.out.println(list.stream().mapToInt(Integer::byteValue).sum());

        list.forEach(s -> System.out.println(list.contains(s)));

        List<Integer> collect = list.stream().filter(
                s -> list2.contains(s))
                .collect(Collectors.toList());

        System.out.println(1);
        System.out.println(collect.size());


    }

    public static void Demo2() {
        List<String> list = Arrays.asList();
    }
}
