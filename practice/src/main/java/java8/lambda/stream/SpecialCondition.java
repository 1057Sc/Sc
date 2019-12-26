package java8.lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SpecialCondition {

    /**
     * 如果 list对象中 的对象属性有list那么 list为null会怎么样子
     *
     */
    @Test
    public void conditionOne(){
        List<SubTestObj> testObjs = new ArrayList<>();
        SubTestObj subTestObj = new SubTestObj();
        subTestObj.setList(new ArrayList<>());
        testObjs.add(subTestObj);

        SubTestObj subTestObj1 = new SubTestObj();
        testObjs.add(subTestObj1);

        SubTestObj subTestObj2 = new SubTestObj();
        subTestObj2.setList(new LinkedList<>());
        testObjs.add(subTestObj2);

        // 如果数组对象中某个对象为null  那么收集后的对象也是null  可以用stream.filter去空
        List<List<String>> collect = testObjs.stream().map(SubTestObj::getList).collect(Collectors.toList());
        System.out.println(collect.size());
    }
}
