package og.sc.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author Sc
 * @date 2021/7/12
 */
public class TimingInterceptor {

    @RuntimeType
    public static Object intercept(@Origin Method method,
                                   @SuperCall Callable<?> callable) {
        long start = System.currentTimeMillis();
        try {
            Object call = callable.call();
            System.out.println(call.toString());
            return call;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println(method + " took " + (System.currentTimeMillis() - start));
        }
    }
}
