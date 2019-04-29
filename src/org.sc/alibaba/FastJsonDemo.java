package alibaba;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import javafx.beans.binding.ObjectExpression;

import java.util.*;

/**
 * Created by duizhuang on 4/29/2019.
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        String jsonStr = "{\"size\":\"7.5\",\"width\":\"M (B)\"}";
        //String jsonStr1 = "[{\"operationId\": \"43\", \"operationName\": \"测试客服专员-4\"}]";
        System.out.println("无序遍历结果：");
/*
        JSONObject jsonObj = JSON.parseObject(jsonStr1);
        for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
*/

        System.out.println("-------------------");
        System.out.println("有序遍历结果：");
        LinkedHashMap<String, String> jsonMap = JSON.parseObject(jsonStr, new TypeReference<LinkedHashMap<String, String>>() {
        });
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            if ("43".equals(entry.getValue())) {

            } else {
                System.out.println("没有这个数");
            }
        }
        System.out.println(jsonMap.containsValue("43"));
        System.out.println(1);

        String jsonmap = "[{\"operationId\": \"43\", \"operationName\": \"测试客服专员-4\"},{\"operationId\": \"45\", \"operationName\": \"测试客服专员-4\"}]";
        List<HashMap<String, Object>> jsonListMap = JSON.parseObject(jsonmap, new TypeReference<List<HashMap<String, Object>>>() {
        });
        List list = new LinkedList();
        for(Map<String,Object> json : jsonListMap){
            list.add(json.get("operationId"));
        }
        System.out.println(list.toString());
        System.out.println(list.contains("47"));
    }
}
