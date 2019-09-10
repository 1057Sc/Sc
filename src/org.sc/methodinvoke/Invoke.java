package methodinvoke;

import trycatch.Demo1;

/**
 * Created by Sc on 6/26/2019.
 */
public class Invoke {

    public static void main(String[] args) {

    }

    private void Demo1() {
        Demo2();
        this.Demo2();
    }

    private void Demo2() {
        System.out.println("I an Demo2");
    }


}
