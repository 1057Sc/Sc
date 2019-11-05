package string;

import org.junit.Test;

public class CommonApi {

    @Test
    public void toCharArray(){
        String cp = "{\"version\":\"1.0.0\",\"signatureVersion\":\"1.0\",\"signatureMethod\":\"HMACSHA1\",\"timestamp\":1572059884074,\"signatureNonce\":\"k26zv5t60.pzh7eu761yr\"}";
        System.out.println(cp.toCharArray());

        String cp2 = "{\"signatureMethod\":\"HMACSHA1\",\"version\":\"1.0.0\",\"signatureVersion\":\"1.0\",\"timestamp\":1572059884074,\"signatureNonce\":\"k26zv5t60.pzh7eu761yr\"}";
        System.out.println(cp2.toCharArray());
    }

    @Test
    public void ObjString(){
        Object s1 = "sajdlajd";
        System.out.println(s1 instanceof String);
        System.out.println(s1.toString());
        System.out.println((String)s1);
    }

}
