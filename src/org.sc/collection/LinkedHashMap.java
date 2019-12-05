package collection;

import java.util.HashMap;
import java.util.Map;

public class LinkedHashMap<K, V>
        extends HashMap<K, V>
        implements Map<K, V> {

    /*static class Entry<K,V> extends HashMap.Node<K,V> {
        java.util.LinkedHashMap.Entry<K,V> before, after;
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
*/
}
