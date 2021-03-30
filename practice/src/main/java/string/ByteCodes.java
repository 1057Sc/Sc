package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sc on 9/10/2019.
 */
public class ByteCodes {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b_utf8 = "深".getBytes("UTF-8");
        System.out.println(Arrays.toString(b_utf8));
    }

    @Test
    public void demo1() {
        String s = "汪";
        System.out.println(s);

        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void demo2() {
        String s = "汪汪汪";
        byte[] encode = Base64.getEncoder().encode(s.getBytes(StandardCharsets.UTF_8));
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode));
    }

    @Test
    public void demo3() {
        String s = "123abc";
        byte[] bytes = s.getBytes();

        byte one = 1;
        byte one1 = '1';
        for (byte aByte : bytes) {
            // Ascii code
            System.out.println(aByte);
        }
    }

}
