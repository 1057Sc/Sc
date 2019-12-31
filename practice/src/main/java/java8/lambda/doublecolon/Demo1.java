package java8.lambda.doublecolon;

import java8.lambda.stream.TestObj;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

public class Demo1 {

    @Test
    public void demo1(){
        Function<Integer, TestObj[]> testCreator = TestObj[]::new;
        TestObj[] computerArray = testCreator.apply(5);
        System.out.println(Arrays.toString(computerArray));
    }
}
