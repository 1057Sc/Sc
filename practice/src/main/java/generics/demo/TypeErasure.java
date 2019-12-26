package generics.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TypeErasure {

    @Test
    public void demo(){
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");

        for (String s : list){
            System.out.println(s);
        }
    }

    @Test
    public void demo1() {
        List<String> list = new ArrayList();
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            String s = (String)var2.next();
            System.out.println(s);
        }

    }
}
