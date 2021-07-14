package buddy;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * @author Sc
 * @date 2021/6/17
 */
public class Bar {

    // @BindingPriority(3)
    public static String sayHelloBar() {
        return "Hello in Bar!";
    }

    @BindingPriority(2)
    public static String sayBar() {
        return "bar";
    }

    public String bar() {
        return Bar.class.getSimpleName() + " - Bar";
    }

}
