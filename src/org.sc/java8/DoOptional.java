package java8;

import com.sun.javaws.exceptions.InvalidArgumentException;
import java8.dooptional.PersonRepository;
import org.junit.Test;

import java.util.Optional;

public class DoOptional {

    private static PersonRepository personRepository = new PersonRepository();

    @Test
    public void whenIdIsNull_thenExceptionIsThrown() {
        Optional.ofNullable(personRepository.findNameById(null))
                .orElseThrow(() -> new IllegalArgumentException("illegal argument , it's not null"))
                .orElseThrow(IllegalStateException::new);
    }

}
