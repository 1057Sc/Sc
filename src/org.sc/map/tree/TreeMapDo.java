package map.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDo {

    @Test
    public void treeMap(){
        Map<Integer, String> treemap = new TreeMap<>();
        treemap.put(3, "TreeMap");
        treemap.put(2, "vs");
        treemap.put(1, "HashMap");
    }

    @Test
    public void hashMap(){
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(3, "TreeMap");
        hashmap.put(2, "vs");
        hashmap.put(1, "HashMap");

    }
}
