/**
 * Created by duizhuang on 8/6/2019.
 */
public class jvm {

    public static void main(String[] args) {

    }


/*
    public void demo1(){
        int k;
        int n = 5;
        if (n > 2)
            k = 3;
        System.out.println(k);  */
/* k is not "definitely assigned"
                               before this statement *//*

    }


    public void demo2(){

        for (i = 0; i < n; ++i) foo();
        int q = (n+7)/8;
        switch (n%8) {
            case 0: do { foo();    // Great C hack, Tom,
                case 7:      foo();    // but it's not valid here.
                case 6:      foo();
                case 5:      foo();
                case 4:      foo();
                case 3:      foo();
                case 2:      foo();
                case 1:      foo();
            } while (--q > 0);
        }
    }
*/

}
