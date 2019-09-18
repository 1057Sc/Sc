package reference;

import java.awt.*;

/**
 * Created by Sc on 6/12/2019.
 */
public class ValueRef {

    public static void main(String[] args) {
 /*       Integer i = 6;
        String s = "sssss";
        Demo1(i,s);
        System.out.println(i);
        System.out.println(s);*/
        Point pnt1 = new Point(0,0);
        Point pnt2 = new Point(0,0);
        System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
        System.out.println(" ");
        tricky(pnt1,pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);

    }

    public static void Demo1(Integer i,String s){
        i+=1;
        s+="777";

    }


    public static void tricky(Point arg1, Point arg2)
    {
        arg1.x = 100;
        arg1.y = 100;
       /* Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;*/
    }




}
