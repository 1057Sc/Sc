package arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sc on 2019/3/6.
 *
 * @Description:
 */
public class Recursion {

    public static void main(String args[]){
        demo(2);
        System.out.println(demo(2));
    }

    public static Map demo(int num){
        List<Map> list0 = new LinkedList();
        for(int i=0;i<num;i++){
            list0.add(i,new HashMap());
        }
        list0.get(0).put("two",list0.get(1));
        int i =0;
        Map map = new HashMap();
        List list = new LinkedList();
        map.put("one",list);
        while(i<num){
            demo(i);
            i++;
        }

        return map;
    }


    public static Map demo2(){
        Map map = new HashMap();

        return null;
    }
}
