package collection.map;

import org.junit.Test;

public class ConcurrentHashMaoDemo {


    @Test
    public void test1() {

        int[] ints = {1, 2, 3};

        for (int[] int123 = ints;;){
            int length = int123.length;
            System.out.println(length);
        }
    }


    @Test
    public void test2(){
        long a = 9;
        long b = 9/2;
        System.out.println(b);
    }
}
