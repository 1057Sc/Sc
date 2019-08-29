package conditionalStatment.dofi.wayone;


import org.junit.Test;

/**
 * Created by duizhuang on 8/29/2019.
 */
public class Calculator {

    public int calculateUsingFactory(int a, int b, String operator) {
        Operation targetOperation = OperatorFactory
                .getOperation(operator)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetOperation.apply(a, b);
    }

    @Test
    public void test() {
        int add = calculateUsingFactory(10, 7, "add");
        System.out.println(add);
    }
}
