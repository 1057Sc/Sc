package object;

import java.util.*;

/**
 * Created by Sc on 2018/11/6.
 */
public class OutList {

    public static void main(String[] args){
        Map m = new HashMap();
        m.put("a",1);
        List list = new LinkedList();
        list.add(m);
        System.out.print(list);

        for(Object l : list){
            System.out.print("list"+l);
        }

        List list1 = new LinkedList();
        list1.add(1);
        System.out.println(list1);
    }
}
