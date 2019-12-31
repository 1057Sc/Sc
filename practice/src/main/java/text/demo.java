package text;

import java.text.MessageFormat;

/**
 * Created by Sc on 6/11/2019.
 */
public class demo {

    public static void main(String[] args) {
        String s ="{0}111";

        System.out.println(MessageFormat.format(s,"p"));

        System.out.println(s);
    }
}
