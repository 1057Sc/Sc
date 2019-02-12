package dynamicProxy;

/**
 * Created by Sc on 2019/2/12.
 *
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        //保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //jdk动态代理测试
        Person person = new JDKDynamicProxy(new IPerson()).getProxy();
        person.doSomething();
    }
}
