package string;

import com.sun.xml.internal.ws.server.ServerRtException;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Sc on 5/9/2019.
 */
public class StringSplit {

   /* public static void main(String[] args) {
        Demo1();
    }

    public static void Demo1(){
        String a = "aaaaaaaa";
        String b = "aaaaaaaa,bbbbbb";
        String[] arr = a.split(",");
        String[] brr = b.split(",");
        System.out.println(arr);
    }*/

    @Test
    public void demo2() {
        String s = "|";

        String s1 = "\\|";

        int i = 5;

        String s2 = "";

        for (int i1 = 0; i1 < i; i1++) {
            s2 = s2 + i1 + s;
        }

        System.out.println(s2);

        String[] split = StringUtils.split(s2, s1);

        System.out.println(Arrays.toString(split));

    }

    @Test
    public void demo3() {

        String s = "1234";
        String[] split = StringUtils.split("2134", "/");
        System.out.println(s);
    }

    @Test
    public void demo1() {
        String s1 = "sc(1231)";
        String minName = s1.trim();

        String min = minName.contains("(")? minName.substring(0, s1.indexOf("(")) : minName;
        System.out.println(min);
    }
}
