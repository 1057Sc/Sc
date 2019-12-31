package java8.dooptional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

   static List<java8.dooptional.Developer> developers = new ArrayList<>();

    static {
        developers.add(new java8.dooptional.Developer());

        for (int i = 0; i< 5; i++){
         java8.dooptional.Developer developer = new java8.dooptional.Developer();
         developer.setId(String.valueOf(i));
         developer.setName("my name is" + i);
         developers.add(developer);
        }
    }

    public Optional<java8.dooptional.Developer> findNameById(String id){
     /*   Optional<Developer> first = developers.stream()
                .filter(dev -> !StringUtils.equals(dev.getId(), id))
                .limit(1)
                .findFirst();*/
        Optional<java8.dooptional.Developer> first = Optional.of(new java8.dooptional.Developer());
        return first;
    }


}
