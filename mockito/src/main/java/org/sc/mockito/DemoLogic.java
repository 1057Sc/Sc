package org.sc.mockito;

public class DemoLogic {

/*    public static void main(String[] args) throws InterruptedException {
        System.out.println(123);
        System.out.println(123);
        System.out.println(123);
        System.out.println(123);
        System.out.println(123);
        for (; ; ) {
            System.out.println(123);
            Thread.sleep(1000);
        }
    }*/

    public void test1(int i) {
        if (i == 1) {
            System.out.println(1);
        }

        if (i == 2) {
            System.out.println(2);
        }
        if (i > 2) {
            System.out.println(">2");
        }
    }
}
