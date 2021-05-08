package generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhuqingxin
 * @date 2021/5/8
 */
public class WildcardsDemo {

    @Test
    public void demo1() {
        orElseThrow(NullPointerException::new);
        orElseThrow1(NullPointerException::new);

    }

    @Test
    public void demo2() {
        List<Number> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(2.0f);
        c1.add(2.0D);

        List<? extends Number> c2 = new ArrayList<>();
        Number a = 1;
        Object o = new Object();
        // c2.add(o);
        // Number number = c2.get(0);

        List<?> c3 = new ArrayList<>();
        // c3.add("1");
    }

    @Test
    public void demo3() {
        List<? super Integer> c1 = new ArrayList<>();
        c1.get(0);
    }


    private <X extends Throwable> void orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {

    }

    private <X extends Throwable> void orElseThrow1(Supplier<X> exceptionSupplier) throws X {

    }
}
