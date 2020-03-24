package concurrency.threadunsafe;

import org.junit.Test;

public class ThreadUnsafe {

    /**
     * It's not thread safe to use volatile or not
     */
    public static volatile int _count = 20;


    /**
     * It's not atomic
     */
    public void unSafe() {
        while (_count > 0) {
            _count--;
            System.out.println(Thread.currentThread().getName() + ":::::::" + _count);
        }
    }

    public void safe() {
        synchronized (this) {
            while (_count > 0) {
                _count--;
                System.out.println(Thread.currentThread().getName() + ":::::::" + _count);
            }
        }
    }

    @Test
    public void run1() {

        Runnable task1 = () -> unSafe();

        Thread thread1 = new Thread(task1);

        Thread thread2 = new Thread(task1);

        thread1.start();
        thread2.start();
    }
}
