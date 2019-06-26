package trycatch;

/**
 * Created by duizhuang on 6/17/2019.
 */
public class Demo1 {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        int i = 0;
        int b = 1;
        try {
            int result = b / b;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            System.out.println(22222);
        }
    }
}
