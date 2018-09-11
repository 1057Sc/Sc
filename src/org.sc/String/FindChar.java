package String;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sc on 2018/7/6.
 *
 */
public class FindChar {

    public static void main(String[] args) {
        String s = "abbcccd";
        List l = new LinkedList();
        int index = 0;
        //demoe();
        List list = find(s,l,index);
        System.out.println(list.size());
    }

    /**
     * 寻找一个字符串中 想要字符的索引 只是索引
     * @param s
     * @param l
     * @param index
     * @return 返回一个List集合 集合内部是这些找到字符的索引值
     */

    public static List find(String s ,List l,int index){

        int f = s.indexOf("c",index);

        if (f!=-1){
            l.add(f);
            index=f+1;
            find(s,l,index);
        }
        //如何List不写泛型 就要把遍历类型写为obj
/*        for(Object x:l){
            System.out.println(x);
        }*/
        return l;
    }

    public static void demoe(){
        String s = "abbcccd";
        //返回的只是索引的位置
        System.out.println(s.indexOf("c",6));
    }
}
