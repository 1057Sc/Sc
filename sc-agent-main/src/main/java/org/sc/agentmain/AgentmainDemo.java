package org.sc.agentmain;

import java.lang.instrument.Instrumentation;

/**
 * @author zhuqingxin
 * @date 2021/6/21
 */
public class AgentmainDemo {

    public static void agentmain(String agentArgs, Instrumentation inst){
        System.out.println(agentArgs);
    }
}
