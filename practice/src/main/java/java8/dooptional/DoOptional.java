package java8.dooptional;

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
        } catch (IllegalArgumentException e) {
            System.out.println(1);
            e.printStackTrace();
        }
    }


    @Test
    public void throwException() {
        throw new RuntimeException();
    }

    @Test
    public void OptionalDemo() {
        String[] words = new String[10];
        String word = words[5].toLowerCase();
        System.out.println(word);
    }

    @Test
    public void OptionalDemo1() {
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        checkNull.ifPresent(System.out::println);
    }


    public static String optionalDemo2(){
        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()){
            return checkNull.get();
        }else {
            System.out.println("null");
            return "";
        }
    }

    public static void main(String[] args) {
        optionalDemo2();
    }
}
