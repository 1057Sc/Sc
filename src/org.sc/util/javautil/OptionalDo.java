package util.javautil;

import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

import static junit.framework.TestCase.assertTrue;

public class OptionalDo {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        // assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test
    public void uuid(){
        String s = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        System.out.println(s);
    }
}
