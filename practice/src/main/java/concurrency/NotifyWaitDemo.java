package concurrency;

public class NotifyWaitDemo {

    public static void main(String[] args) {
        char[] chars = "ABDCDEF".toCharArray();
        char[] chars1 = "123457".toCharArray();

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (char aChar : chars) {
                    System.out.println(aChar);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
               // lock.notify();
            }
        }).start();


        new Thread(() -> {
            synchronized (lock) {
                for (char aChar : chars1) {
                    System.out.println(aChar);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();

    }
}
