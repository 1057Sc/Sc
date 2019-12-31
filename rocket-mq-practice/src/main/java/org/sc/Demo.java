package org.sc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Set<Map.Entry<String, Integer>> entries1 = map.entrySet();
        Integer reduce = entries.stream().map(Map.Entry::getValue).reduce(1, (x, y) -> (x * y));
        System.out.println(reduce);
    }
}
