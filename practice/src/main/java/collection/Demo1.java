package collection;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhuqingxin
 * @date 2021/4/20
 */
public class Demo1 {

    @Test
    public void remove() {
        List<Integer> collect1 = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> collect2 = Stream.of(1, 2).collect(Collectors.toList());

        // boolean b = collect2.removeAll(collect1);
        boolean b = collect1.removeAll(collect2);
        System.out.println(1);
    }
}
