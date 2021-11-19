package text;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by Sc on 6/11/2019.
 */
public class demo {

/*    public static void main(String[] args) {
        String s ="{0}111";

        System.out.println(MessageFormat.format(s,"p"));

        System.out.println(s);
    }*/

    @Test
    public void demo() {
        Integer i = 12321321;

        String s = "{0}hcisjkshdjksa";

        String format = MessageFormat.format(s, i);
        System.out.println(format);
    }
}
