package collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sc on 6/27/2019.
 */
public class MapNull {

    public static void main(String[] args) {

       /* Map m = dmoe1();
        String s = (m == null ? "0" : "1");
        System.out.println(s);*/
        demo3();
    }

    public static Map dmoe1() {

        Map m = null;

        return m;
    }

    private static void demo2() {

        Map m = new HashMap();
        System.out.println(m.size());
    }

    private static void demo3() {
        List<Map> list = new ArrayList<>();
        Map m = new HashMap();
        Map m1 = new HashMap();
        Map m2 = new HashMap();
        Map m3 = new HashMap();
        Map m4 = new HashMap();

        list.add(m);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        System.out.println(list);

        List<Map> list1 = new ArrayList<>();
        Map m7 = null;
        list1.add(null);
        list1.add(m7);
        list1.add(m7);
        list1.add(m7);
        list1.add(m7);
        list1.add(m7);
        list1.add(m7);
        System.out.println(list1.size());
        System.out.println(list1);

    }
}
