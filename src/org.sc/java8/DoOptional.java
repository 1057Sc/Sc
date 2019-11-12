package java8;

import java8.dooptional.PersonRepository;
import org.junit.Test;

import java.util.Optional;

public class DoOptional {

    private static PersonRepository personRepository = new PersonRepository();

    @Test
    public void whenIdIsNull_thenExceptionIsThrown() {
        try {
            Optional.ofNullable(personRepository.findNameById(null))
                    .orElseThrow(() -> new IllegalArgumentException("illegal argument , it's not null"));
        }catch (IllegalArgumentException e){
            System.out.println(1);
            e.printStackTrace();
        }
    }


    @Test
    public void throwException(){
        throw new RuntimeException();
    }
}
