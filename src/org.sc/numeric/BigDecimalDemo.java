package numeric;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Sc on 7/1/2019.
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        BigDecimal bigDecimal = new BigDecimal(BigInteger.ZERO);
        bigDecimal = bigDecimal.add(new BigDecimal(700));
        System.out.println(bigDecimal);
        bigDecimal = bigDecimal.negate();
        System.out.println(bigDecimal);

    }
}
