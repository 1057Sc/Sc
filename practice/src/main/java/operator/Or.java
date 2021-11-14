package operator;

import org.junit.Test;

/**
 * Created by Sc on 6/28/2019.
 */
public class Or {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        System.out.println(3 | 9);
    }

    @Test
    public void demo2() {
        System.out.println(1);
        System.out.println(1 << 1);
        System.out.println((1 << 2) - 1);
    }

    @Test
    public void demo3() {
        System.out.println(7 & 3);
    }
}
