package string;

import com.sun.xml.internal.ws.server.ServerRtException;

/**
 * Created by Sc on 5/9/2019.
 */
public class StringSplit {

    public static void main(String[] args) {
        Demo1();
    }

    public static void Demo1(){
        String a = "aaaaaaaa";
        String b = "aaaaaaaa,bbbbbb";
        String[] arr = a.split(",");
        String[] brr = b.split(",");
        System.out.println(arr);
    }
}
