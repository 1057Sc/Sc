package reflect.invokedynamic;

import com.sun.tools.javac.util.List;

import java.util.stream.Stream;

public class FooCode {

    public static void main(String[] args) {
        long size = Stream.of(1, 2, 3).filter(num -> num > 1).count();
        System.out.println(size);
    }


/*    public static void main(String[] args) {
        long lengthyColors = List.of("Red", "Green", "Blue")
                .stream().filter(c -> c.length() > 3).count();
    }*/
}
