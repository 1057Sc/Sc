package collection.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDo {

    @Test
    public void demo2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        HashSet<Integer> integers = new HashSet<>(list);
        System.out.println(integers.toString());
    }


    @Test
    public void demo1() {
        String[] s = new String[10];
        Set<Integer> source = new HashSet<>();
        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);

        Set<Integer> target = new HashSet<>();
        target.add(7);
        target.add(8);
        target.add(9);

        // 取交集
        boolean b = source.retainAll(target);
        System.out.println(b + "::::" + source.toString());


    }

    @Test
    public void demo3() throws Exception {

        Set<Integer> source = new HashSet<>();
        source.add(1);
        source.add(2);

        Set<Integer> sourceCopy = new HashSet<>(source);
        System.out.println(sourceCopy);


        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(3);
        target.add(4);

        // 取交集
        boolean b = sourceCopy.retainAll(target);
        System.out.println(b + "::::" + sourceCopy.toString());

        // 取差集
        source.removeAll(sourceCopy);
        target.removeAll(sourceCopy);
        System.out.println(source +":::::::::"+ target);
    }

    @Test
    public void demo4() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        //交集
        set1.retainAll(set2);

        System.out.println("交集是 " + set1);
    }

    @Test
    public void demo5(){
        Set<Integer> source = new HashSet<>();
        source.add(1);
        source.add(2);

        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(3);
        target.add(4);

        source.removeAll(target);
        System.out.println(source);
    }

    @Test
    public void demo6(){
        Set<Integer> source = new HashSet<>();
        source.add(1);
        source.add(2);
        source.add(4);

        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(2);
        target.add(3);
        source.retainAll(target);

        System.out.println(source.toString());

    }

    @Test
    public void demo7(){
        Set<Integer> source = new HashSet<>();
        source.add(1);
        source.add(2);
        source.add(3);

        Set<Integer> target = new HashSet<>();
        target.add(3);
        target.add(4);


        boolean b = source.retainAll(target);
        System.out.println(b);
    }
}
