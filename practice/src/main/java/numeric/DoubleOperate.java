package numeric;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class DoubleOperate {

    @Test
    public void test1(){
        double s1 = 0.77;
        double s2 = 0.61;
        double s3 = 0.80;
        double s4 = 0.91;
        List<Double> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        double asDouble = list.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(asDouble);
        System.out.println(new BigDecimal("1.00").subtract(new BigDecimal(asDouble)));

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        System.out.println(percent.format(new BigDecimal("1.00").subtract(new BigDecimal(asDouble))));
    }
}
