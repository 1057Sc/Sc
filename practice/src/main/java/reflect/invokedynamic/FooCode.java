package reflect.invokedynamic;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FooCode {

    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3).collect(Collectors.toList());

        List<String> strings = Lists.newArrayList("1", "2", "345");
        strings.stream()
                .forEach(string -> Arrays.stream(string.split("")).forEach(System.out::println));

        long lengthyColors = Lists.newArrayList("Red", "Green", "Blue").stream().filter(c -> c.length() > 3).count();
    }


/*    public static void main(String[] args) {
        long lengthyColors = List.of("Red", "Green", "Blue")
                .stream().filter(c -> c.length() > 3).count();
    }*/
}
