package og.sc.agent;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author Sc
 * @date 2021/7/11
 */
public class RedefineFoo {

    public static void doRedefine() {
        try {
            // 重新定义已经加载过的类 需要使用ByteBuddyAgent
            Instrumentation install = ByteBuddyAgent.install();
            // 重新定义类
            new ByteBuddy().redefine(Foo.class)
                    // 匹配方法
                    .method(ElementMatchers.named("sayHelloFoo"))
                    // 拦截
                    .intercept(FixedValue.value("Hello Foo Redefined"))
                    .make()
                    // 加载  ClassReloadingStrategy提供了多种重加载策略
                    .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
            Foo f = new Foo();
            String s = f.sayHelloFoo();
            // 重新定义后输出：Hello Foo Redefined
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
