package javaStatement.dovolatile;

/**
 * Created by Sc on 8/13/2019.
 * @Description : 这是一个不安全的例子
 */
class Test extends Thread{

    static int i = 0, j = 0;
    static void one() { i++; j++; }
    static void two() {
        System.out.println("i=" + i + " j=" + j);
    }

    @Override
    public void run() {
        one();
        two();
    }

    public static void main(String[] args) {

            Test t1 = new Test();
            Test t2 = new Test();
            t1.start();
            t2.start();

    }

}
