package logicSyntax;

/**
 * Created by Sc on 2018/11/8.
 */
public class Switch {
    public static void main(String[] args){
        demo();
        demo2(2);
    }

    public static void demo(){
        String a = "A";
        switch (a){
            case "A":
                System.out.println("A");
            case "B":
                System.out.println("B");
        }
    }

    public static void demo2(int a){
        int i = 1;
        switch (a){
            case 1:
                System.out.println("I'm 1");
            case 2:
                System.out.println("I'm 2");
        }

    }

}
