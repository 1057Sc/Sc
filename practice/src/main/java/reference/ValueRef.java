package reference;

import org.junit.Test;

import javax.crypto.spec.OAEPParameterSpec;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sc on 6/12/2019.
 */
public class ValueRef {

    public static void main(String[] args) {
 /*       Integer i = 6;
        String s = "sssss";
        Demo1(i,s);
        System.out.println(i);
        System.out.println(s);*/
        Point pnt1 = new Point(0, 0);
        Point pnt2 = new Point(0, 0);
        System.out.println("X: " + pnt1.x + " Y: " + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " + pnt2.y);
        System.out.println(" ");
        tricky(pnt1, pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " + pnt2.y);

    }

    public static void Demo1(Integer i, String s) {
        i += 1;
        s += "777";

    }


    public static void tricky(Point arg1, Point arg2) {
        arg1.x = 100;
        arg1.y = 100;
       /* Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;*/
    }


    @Test
    public void demo1() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");

        ObjList objList = new ObjList();
        objList.setList(strings);
        System.out.println(strings.toString());

        objList.getList().add("7");
        System.out.println(strings.toString());
    }

    @Test
    public void demo2() {
        ArrayList<String> strings = new ArrayList<>();

        if (true) {
            ArrayList<String> objects = new ArrayList<>();
            objects.add("sad");
            objects.add("d");
            objects.add("szzz");
            strings = objects;
            System.out.println(1231321213);
        }

        System.out.println(strings);
    }

    @Test
    public void demo3() {
        HashMap<Long, Long> zzzz = new HashMap<>();
        if (true) {
            HashMap<Long, Long> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put(12321L, 1232131L);
            zzzz = objectObjectHashMap;
            System.out.println(12321321);
        }
        System.out.println(zzzz);
    }



}
