package basic;

/**
 * Created by Sc on 2018/6/20.
 */
public class BitOperation {

   static int a = 1;

   static Integer i = 1;

    public static void main(String[] args){

        bit();
        System.out.println(a);
    }

    public static int bit(){
        a = 1 << 1; //2
        a = 1 << 2; //4
        System.out.println(a);
        return a;
    }
}
