package innerClass;

/**
 * stack overflow:
 *
 * https://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class#:~:targetText=When%20an%20anonymous%20inner%20class,values%2C%20the%20reference%20cannot%20change.
 *
 * anonymous class
 */
public class InnerClassDemo {

    public void demo1(){


        // this final can be omitted in java 8 later
        final String str = "test1";

        new Thread(){
            @Override
            public void run() {
                System.out.println(str);
            }
        };

        new Thread(() -> {
            System.out.println("str");
        });
    }
}
