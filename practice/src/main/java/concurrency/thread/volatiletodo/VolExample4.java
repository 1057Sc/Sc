package concurrency.thread.volatiletodo;

public class VolExample4 {

    static int i = 0, j = 0;

    static void one() {
        i++;
        j++;
    }

    static void two() {
        System.out.println("i=" + i + " j=" + j);
    }

    private static final Integer THREAD_COUNT = 2;

    public static void main(String[] args) {

        VolExample4 vol = new VolExample4();
        ThreadF1 threadF1 = vol.new ThreadF1();
        ThreadF2 threadF2 = vol.new ThreadF2();
        threadF1.start();
        threadF2.start();
    }

    class ThreadF1 extends Thread {

        @Override
        public void run() {
            //for (int i = 0; i < 50; i++) {
                one();
            //}
        }
    }

    class ThreadF2 extends Thread {
        @Override
        public void run() {
            // for (int i = 0; i < 50; i++) {
                two();
            // }
        }
    }
}
