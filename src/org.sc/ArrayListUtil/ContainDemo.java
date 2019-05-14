package ArrayListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duizhuang on 5/8/2019.
 */
public class ContainDemo {

    public static void main(String[] args) {

         String s = "3";
         List list = new ArrayList<>();
         Long l = 3L;
         list.add(s);
        System.out.println(list.contains(l.toString()));
    }
}
