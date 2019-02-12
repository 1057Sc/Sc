package dynamicProxy;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Sc on 2019/2/12.
 *
 * @Description: 实现InvocationHandler，
 */
public class JDKDynamicProxy implements InvocationHandler {

    //需要为其创建代理对象的类
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     *
     * @param <T>
     * @return Proxy.newProxyInstance为了创建一个新的代理对象
     *
     */
    public <T> T getProxy(){

        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I am invoke before");
        Object result = method.invoke(target,args);
        System.out.println("I am invoke after");
        return result;
    }
}
