package og.sc.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author zhuqingxin
 * @date 2021/6/21
 */
public class AgentDemo {

    /**
     * agent方法
     *
     * @param agentArgs
     * @param instrumentation
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("premain start");
        System.out.println(agentArgs);
    }
}
