package concurrency.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolExample2 {


    static AtomicInteger count1 = new AtomicInteger(50);

    static volatile int count = 50;

    private static final Integer THREAD_COUNT = 3;

    static  void subTract() {
        while (count1.intValue() > 0) {
            System.out.println(Thread.currentThread().toString() + count1.decrementAndGet());
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    subTract();
                }
            });
            threads[i].start();
        }
    }
}
