package reflect.dynamicProxy;

/**
 * Created by Sc on 2019/2/12.
 *
 * @Description: 实现Person接口
 */
public class IPerson implements Person {

    @Override
    public void doSomething() {
        System.out.println("I am IPerson");
    }
}
