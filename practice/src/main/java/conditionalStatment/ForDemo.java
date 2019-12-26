package conditionalStatment;

/**
 * Created by Sc on 8/13/2019.
 */
public class ForDemo {

    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 10 - i; j++) {
                System.out.println("j = " + j);
                break;
            }
            break;
        }
    }
}
