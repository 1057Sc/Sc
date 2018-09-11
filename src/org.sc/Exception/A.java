package Exception;

/**
 * Created by Sc on 2018/7/27.
 */
public class A {

    public static void main(String[] args) throws Exception {
        Class clazz =Class.forName("Exception.B");
        Object b = clazz.getConstructor().newInstance();
        System.out.println(b);
        System.out.println(clazz);
    }
}
