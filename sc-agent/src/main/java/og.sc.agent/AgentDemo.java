package og.sc.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author Sc
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
        new AgentBuilder.Default()
                .type(ElementMatchers.isAnnotatedWith(Timer.class))
                .transform((builder, type, classLoader, module) ->
                        builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(TimingInterceptor.class))
                ).installOn(instrumentation);
    }

}
