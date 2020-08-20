package collection.ArrayListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sc on 5/8/2019.
 */
public class ContainDemo {

    public static void main(String[] args) {

    /*     String s = "3";
         List list = new ArrayList<>();
         Long l = 3L;
         list.add(s);
        System.out.println(list.contains(l.toString()));*/

        List<Integer> integers = Arrays.asList(1);
/*

        integers.add(1);
        System.out.println(1);
*/

        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);

        Integer[] integers1 = objects.toArray(new Integer[0]);
        System.out.println(integers1.length);
    }

}
