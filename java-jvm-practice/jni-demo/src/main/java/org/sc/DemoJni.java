package org.sc;

/**
 *
 * @author Sc
 * @date 2021/7/14
 */
public class DemoJni {

    public static native String sayHello(String name);

    static {
        try {
            System.loadLibrary("sayHello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello " + sayHello("Sc"));
    }
}
