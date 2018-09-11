package Map;

import java.util.*;

/** Map操作的练习
 * Created by Sc on 2018/8/16.
 */
public class MapPractice {

    public static void main(String[] args){
        Practice1();
    }

    public static void Practice1(){
        HashMap map = new HashMap();
        map.put("key1",1);
        map.put("key2",2);
        //得到所有key值
        Set<String> keys =map.keySet();

        for(String s :keys) {
            System.out.println(s);
        }
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

    }
}
