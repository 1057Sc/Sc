package string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by Sc on 9/10/2019.
 */
public class ByteCodes {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b_utf8 = "深".getBytes("UTF-8");
        System.out.println(Arrays.toString(b_utf8));
    }
}
