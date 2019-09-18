package contain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sc on 4/28/2019.
 */
public class MapContainsValue {

    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", "1123");
        map1.put("name", "张三");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", "2");
        map2.put("name", "李四");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("id", "1123");
        map3.put("name", "王五");
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("id", "3");
        map4.put("name", "赵六");
        Set set = map1.entrySet();

        System.out.println(set);

    }
}
