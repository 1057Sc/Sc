package generics.official;

import generics.Foo;

import java.lang.reflect.ParameterizedType;

@Foo
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
/*
    private Class<T> clazz;

    // 使用反射得到T的真实类型
    public Class getRealType() {
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        return clazz;
    }*/


}

