package scagent;

/**
 * add vm Option: -javaagent:sc-agent-1.0-SNAPSHOT.jar=hello
 *
 * @author Sc
 * @date 2021/6/21
 */
public class AgentDemoStart {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.getName();
        System.out.println("start");
    }
}
