package arithmetic;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

public class DoubleOperate {

    @Test
    public void demo1() {
        BigDecimal x = new BigDecimal(1754D);
        BigDecimal x1 = new BigDecimal(2502D);
        BigDecimal x2 = new BigDecimal(160);
        BigDecimal divide = x.multiply(x2).divide(x1, 0, ROUND_HALF_DOWN);

        System.out.println(divide.intValue());
    }
}
