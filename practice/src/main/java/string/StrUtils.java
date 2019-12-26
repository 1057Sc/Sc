package string;

import org.junit.Test;

public class StrUtils {

    /**
     *首字母大写转换  toggle case
     * ASCII 码前移，ASCII 中大写字母从65开始，小写字母从97开始
     */
    @Test
    public void demo1(){
        String s = "demo";
        char[] chars = s.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
            System.out.println(chars[0]);
        }
        System.out.println(new String(chars));
    }

    @Test
    public void dmeo2(){
        String s = "https:/";
        boolean h = s.startsWith("https");
        System.out.println(h);
    }
}
