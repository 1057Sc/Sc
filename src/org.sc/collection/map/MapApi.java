package collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapApi {

    @Test
    public void hcode() {
        int h;
        int i = (h = "key".hashCode()) ^ (h >>> 16);
        System.out.println(i);
        HashMap map = new HashMap();
        map.put("key","keyone");

    }

    @Test
    public void hcode1(){
        System.out.println( 1 >>> 3);
        System.out.println( -2 << 3);
    }
}
