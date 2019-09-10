package reference;

/**
 * Created by Sc on 6/12/2019.
 */
public class ValueRef {

    public static void main(String[] args) {
        Integer i = 6;
        String s = "sssss";
        Demo1(i,s);
        System.out.println(i);
        System.out.println(s);

    }

    public static void Demo1(Integer i,String s){
        i+=1;
        s+="777";

    }






}
