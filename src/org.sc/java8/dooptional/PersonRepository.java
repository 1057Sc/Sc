package java8.dooptional;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonRepository {

   static List<Developer> developers = new ArrayList<>();

    static {
        developers.add(new Developer());

        for (int i = 0; i< 5; i++){
         Developer developer = new Developer();
         developer.setId(String.valueOf(i));
         developer.setName("my name is" + i);
         developers.add(developer);
        }
    }

    public Optional<Developer> findNameById(String id){
        Optional<Developer> first = developers.stream()
                .filter(dev -> !StringUtils.equals(dev.getId(), id))
                .limit(1)
                .findFirst();

        return first;
    }


}
