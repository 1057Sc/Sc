package concurrency.threadunsafe;

import org.junit.Test;

public class ThreadUnsafe {

    /**
     * It's not thread safe to use volatile or not
     */
    public static volatile int _count = 20;


    public void test1() {

        while (_count > 0) {
            _count--;
            System.out.println(Thread.currentThread().getName() + ":::::::" + _count);
        }

    }

    @Test
    public void run1() {

        Runnable task1 = () -> test1();

        Thread thread1 = new Thread(task1);

        Thread thread2 = new Thread(task1);

        thread1.start();
        thread2.start();
    }
}
