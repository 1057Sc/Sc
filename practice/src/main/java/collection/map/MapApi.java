package collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapApi {

    @Test
    public void hcode() {
        int h;
        int i = (h = "key".hashCode()) ^ (h >>> 16);
        // (p = tab[i = (n - 1) & hash]) 这边作用的应该是为了减少hash碰撞 毕竟初始的table size没有那么大

        System.out.println(i);
        HashMap map = new HashMap();
        map.put("key", "keyone");

    }

    @Test
    public void hcode1() {
        System.out.println(1 >>> 3);
        System.out.println(-2 << 3);
        System.out.println(1111111111 >> 10);
    }


    @Test
    public void hcode2() {
        int i = 10000000;
        System.out.println(i >> 2);
        System.out.println((i >> 2) & 0xff);

        System.out.println(Integer.toBinaryString(512 >> 2));
    }

}
