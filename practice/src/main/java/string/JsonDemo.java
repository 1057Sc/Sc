package string;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo {

    @Test
    public void json(){
        List<String> content = new ArrayList<>();
        content.add("1");
        content.add("1");
        content.add("1");
        content.add("1");
        content.add("1");
        content.add("1");


        List<List<String>> contentList = new ArrayList<>();
        contentList.add(content);


        System.out.println(JSON.toJSON(contentList));
    }
}
