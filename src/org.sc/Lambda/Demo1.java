package Lambda;

/**
 * Created by Sc on 2018/12/19.
 */
public class Demo1 {
    final static String salutation = "Hello! ";

    public static void main(String args[]){
        //直接实现一个接口
        GreetingService greetService1 = message ->
                System.out.println(message);//这里为实现逻辑
        greetService1.sayMessage("Runoob");//这里为逻辑调用

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
