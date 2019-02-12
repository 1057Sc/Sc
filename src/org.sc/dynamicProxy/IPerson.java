package dynamicProxy;

/**
 * Created by Sc on 2019/2/12.
 *
 * @Description: java类（接口）作用描述
 */
public class IPerson implements Person {

    @Override
    public void doSomething() {
        System.out.println("I am IPerson");
    }
}
