package generics.official;

import generics.Foo;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;
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

    @Test
    public void demo2(){
/*        Node<String> stringNode = new Node<>("11");
        Class realType = stringNode.getRealType();
        Annotation[] annotations = realType.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        Annotation annotation = realType.getAnnotation(Foo.class);
        System.out.println(annotation.annotationType());*/
    }
}
