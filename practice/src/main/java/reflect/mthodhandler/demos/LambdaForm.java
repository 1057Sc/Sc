package reflect.mthodhandler.demos;

import java.util.function.Supplier;

public class LambdaForm {


    Supplier<Integer> incrementer( int start) {
        return () -> start;
    }

    public static void main(String[] args) {

    }

}
