package concurrent.thread;

public class VolExample3 {

    volatile int cc;

    public static void main(String[] args) {
        VolExample3 volExample3 = new VolExample3();
        Thread111111 thread111111 = volExample3.new Thread111111();
        Thread2222222 thread2222222 = volExample3.new Thread2222222();
        Thread33333 thread33333 = volExample3.new Thread33333();
        Thread44444 thread44444 = volExample3.new Thread44444();

        thread111111.start();
        thread33333.start();
        thread44444.start();
        //thread2222222.start();

    }


    class Thread111111 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                cc++;
                System.out.println(cc + Thread.currentThread().getName());
            }
        }
    }

    class Thread2222222 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                cc++;
                System.out.println(cc + Thread.currentThread().getName());
            }
        }
    }

    class Thread33333 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(cc + Thread.currentThread().getName());
            }
        }
    }

    class Thread44444 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(cc + Thread.currentThread().getName());
            }
        }
    }
}
