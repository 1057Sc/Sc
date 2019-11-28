package concurrent.thread.volatiletodo;

/**
 * Created by Sc on 8/13/2019.
 *
 * @Description : 这是一个不安全的例子
 */
class Test extends Thread {

    static volatile int i = 0, j = 0;

    static void one() {
        i++;
        j++;
    }

    static void two() {
        System.out.println("i=" + i + " j=" + j);
    }

    private static final Integer THREAD_COUNT = 2;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    one();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    two();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread1.start();
                thread2.start();
            }
        });

        thread3.start();
    }

}
