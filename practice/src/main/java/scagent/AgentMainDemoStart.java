package scagent;

/**
 * @author Sc
 * @date 2021/6/21
 */
public class AgentMainDemoStart {

    public static void sayHello(String name) {
        System.out.println(String.format("%s say hello!", name));
    }

    public static void main(String[] args) throws Exception {
        for (; ; ) {
            Thread.sleep(1000);
            sayHello(Thread.currentThread().getName());
        }
    }

}
