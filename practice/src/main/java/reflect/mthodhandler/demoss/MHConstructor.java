package reflect.mthodhandler.demoss;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * MethodHandle 执行构造函数
 *
 * @author zhuqingxin
 * @date 2021/3/10
 */
public class MHConstructor {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle constructor = lookup.findConstructor(MHConstructor.class, MethodType.methodType(void.class));
        MHConstructor o = (MHConstructor) constructor.invoke();
        System.out.println(o);
    }

    public MHConstructor() {
        System.out.println("午餐出动");
    }
}
