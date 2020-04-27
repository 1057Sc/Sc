package concurrency.reentrantdo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {


    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();

        final Condition one = lock.newCondition();

        char[] chars = "ABDCDEF".toCharArray();
        char[] chars1 = "123457".toCharArray();

        new Thread(() -> {
            try {
                lock.lock();

                for (char aChar : chars) {
                    System.out.println(aChar);
                    one.signal();
                    one.await();
                }

                one.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            try {
                lock.lock();
                for (char aChar : chars1) {
                    System.out.println(aChar);
                    one.signal();
                    one.await();
                }

                one.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
