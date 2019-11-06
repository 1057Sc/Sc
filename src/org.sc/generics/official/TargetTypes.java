package generics.official;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class TargetTypes {

    @Test
    public void demo1(){
        List<String> listOne = Collections.emptyList();
        processStringList(Collections.emptyList());
    }

    static void processStringList(List<String> stringList) {
        // process stringList
    }
}
