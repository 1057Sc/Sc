package regex;

import collection.Demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sc on 6/12/2019.
 */
public class Regex {

/*    public static void main( String args[] ){

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String url = "jdbc:postgresql://10.0.0.14:5432/Sc_test";
        String pattern = "(\\D*)(\\d+)(.*)";

        String patternUrl = "(\\d)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }*/

    public static void main(String[] args) {
        Demo2();
    }

    public static void Demo2(){
        String url = "jdbc:postgresql://10.0.0.14:5432/Sc_test";
        String url2 = "rtsp://admin:admin@192.168.30.98:554/media/video1";

        String patternUrl = "(\\^d)";

        String patter3 = "jdbc:postgresql://([0-9]{1,3}.)([0-9]{1,3})*";

        Pattern r = Pattern.compile(patternUrl);
        Matcher m = r.matcher(url);

        Pattern p = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+):(\\d+)");
        Matcher m1 = p.matcher(url2);

        Pattern pattern = Pattern.compile(patter3);
        Matcher m3 = r.matcher(url);
        System.out.println(m3.find());

        while(m3.find()){
            System.out.println(m3.group(1));
        }

        System.out.println(m1);
    }
}
