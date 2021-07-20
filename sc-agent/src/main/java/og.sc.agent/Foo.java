package og.sc.agent;

/**
 * @author Sc
 * @date 2021/7/11
 */
public class Foo {

    public static String sayHelloFoo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Foo!";
    }
}
