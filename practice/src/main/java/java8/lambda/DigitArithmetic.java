package java8.lambda;

/**
 * Created by Sc on 2018/12/25.
 */
public class DigitArithmetic<R>{

    public static void main(String args[]) {
        DigitArithmetic digitArithmetic = new DigitArithmetic();
        MathOperation addition = (int a, int b) -> a + b;
        digitArithmetic.operate(1,2,addition);
    }

    public R method1(R arg1,R arg2){
        return arg1;
    }

    interface MathOperation{
        int operation(int a,int b);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
