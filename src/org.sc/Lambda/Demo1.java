package Lambda;

/**
 * Created by Sc on 2018/12/19.
 */
public class Demo1 {
    final static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(message);
        greetService1.sayMessage("Runoob");

        SayHello sayHello = sayHeelo ->
                System.out.println(sayHeelo);
        sayHello.sayMessage("hello");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface SayHello{
        void sayMessage(String msg);
    }

}
