package buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Sc
 * @date 2021/6/17
 */
public class ByteBuddyDemo {

    /**
     * 重新定义toString
     *
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void givenObject_whenToString_thenReturnHelloWorldString() throws InstantiationException, IllegalAccessException {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
                // 定义子类
                .subclass(Object.class)
                // 匹配方法
                .method(ElementMatchers.isToString())
                // 拦截
                .intercept(FixedValue.value("Hello World ByteBuddy!"))
                // Creates the dynamic type this builder represents.
                .make();
        // 双亲委派式加载
        Class<?> dynamicType = unloadedType.load(getClass().getClassLoader()).getLoaded();

        // 输出结果 Hello World ByteBuddy!
        System.out.println(dynamicType.newInstance().toString());

        Assert.assertEquals(dynamicType.newInstance().toString(), "Hello World ByteBuddy!");
    }

    /**
     * 定义已加载过类使用ByteBuddyAgent
     *
     * @throws Exception
     */
    @Test
    public void givenFoo_whenRedefined_thenReturnFooRedefined() throws Exception {
        // 重新定义已经加载过的类 需要使用ByteBuddyAgent
        ByteBuddyAgent.install();
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
        Assert.assertEquals(f.sayHelloFoo(), "Hello Foo Redefined");
    }

    /**
     *
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void givenSayHelloFoo_whenMethodDelegation_thenSayHelloBar() throws IllegalAccessException, InstantiationException {

        String r = new ByteBuddy().subclass(Foo.class)
                // 匹配方法
                .method(ElementMatchers.named("sayHelloFoo")
                        .and(ElementMatchers.isDeclaredBy(Foo.class).and(ElementMatchers.returns(String.class)))
                )
                // 委托方法 配合@BindingPriority(2)使用
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .sayHelloFoo();

        System.out.println(r);
        System.out.println(Bar.sayHelloBar());

        Assert.assertEquals(r, Bar.sayHelloBar());
    }

    /**
     * 定义一个MyClassName.class
     * <code>@BindingPriority</code>注解提供了一种按注解匹配的方法的规则
     *
     * @throws Exception
     */
    @Test
    public void givenMethodName_whenDefineMethod_thenCreateMethod() throws Exception {
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .name("MyClassName")
                // 定义方法
                .defineMethod("custom", String.class, Modifier.PUBLIC)
                // 委托方法 配合@BindingPriority(2)使用
                .intercept(MethodDelegation.to(Bar.class))
                // 定义字段
                .defineField("x", String.class, Modifier.PUBLIC).make()
                // 加载
                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded();

        // 用反射的方式访问刚定义的方法
        Method m = type.getDeclaredMethod("custom", null);

        System.out.println(m.invoke(type.newInstance()));
        System.out.println(Bar.sayHelloBar());
        // 用反射的方式访问刚定义的字段
        System.out.println(type.getDeclaredField("x"));
        Assert.assertEquals(m.invoke(type.newInstance()), Bar.sayHelloBar());
        Assert.assertNotNull(type.getDeclaredField("x"));

    }
}
