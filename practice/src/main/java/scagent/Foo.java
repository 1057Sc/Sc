package scagent;

import og.sc.agent.Timer;

/**
 * @author Sc
 * @date 2021/7/11
 */
@Timer
public class Foo {

    public String getName(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "foo";
    }
}
