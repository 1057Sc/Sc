package java8.lambda.doublecolon;

import java8.lambda.stream.TestObj;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo1 {

    @Test
    public void demo1() {
        Function<Integer, TestObj[]> testCreator = TestObj[]::new;
        TestObj[] computerArray = testCreator.apply(5);
        System.out.println(Arrays.toString(computerArray));
    }


    @Test
    public void demo2() {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Stream<String> sdsadas = Stream.of("1", "2", "3", "4");
        String collect = sdsadas.collect(Collectors.joining(","));
        System.out.println(collect);
    }


}
