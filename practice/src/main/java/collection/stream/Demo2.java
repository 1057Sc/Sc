package collection.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo2 {

    public static void main(String[] args) {

        System.out.println(4 / 5);
        Demo1();
    }

    public static void Demo1() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        System.out.println(list.stream().mapToInt(Integer::byteValue).sum());
    }

}
