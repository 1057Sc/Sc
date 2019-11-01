package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by Sc on 9/10/2019.
 */
public class ByteCodes {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b_utf8 = "深".getBytes("UTF-8");
        System.out.println(Arrays.toString(b_utf8));
    }

    @Test
    public void demo1(){
        String s = "汪";
        System.out.println(s);

        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
