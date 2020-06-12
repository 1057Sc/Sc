package generics.official;

import generics.Foo;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class NodeSub extends Node<String> {


    public NodeSub(String data) {
        super(data);
    }

    public static void main(String[] args) {


        NodeSub nodeSub = new NodeSub("1");
        Type genericSuperclass = nodeSub.getClass().getGenericSuperclass();

        String typeName = genericSuperclass.getTypeName();
        System.out.println(typeName);

        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = pt.getActualTypeArguments();
            System.out.println(Arrays.toString(actualTypeArguments));
        }

        System.out.println(1);
/*        Class realType = stringNode.getRealType();
        Annotation[] annotations = realType.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        Annotation annotation = realType.getAnnotation(Foo.class);
        System.out.println(annotation.annotationType());*/
    }
}
