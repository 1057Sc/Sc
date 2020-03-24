package concurrency.thread;

public class Volexample {
    int cc = 0;

    public static void main(String[] args) {
        Volexample ve = new Volexample();
        CountClass count = ve.new CountClass();
        Thread1 t1 = ve.new Thread1(count);
        Thread2 t2 = ve.new Thread2(count);
        t1.start();
        t2.start();
    }

    class Thread1 extends Thread {
        CountClass count = new CountClass();

        Thread1(CountClass count) {
            this.count = count;
        }

        @Override
        public void run() {
            /*for(int i=0;i<=5;i++)
            count.countUp();*/
            for (int i = 0; i <= 5; i++) {
                cc++;
                System.out.println(cc + "thread1" +Thread.currentThread().getName());
            }
        }
    }

    class Thread2 extends Thread {
        CountClass count = new CountClass();

        Thread2(CountClass count) {
            this.count = count;
        }

        @Override
        public void run() {
            /*for(int i=0;i<=5;i++)
            count.countUp();*/
            for (int i = 0; i <= 5; i++) {
                cc++;
                System.out.println(cc + "thread2" + Thread.currentThread().getName());
            }
        }
    }

    class CountClass {
        volatile int count = 0;

        void CountClass() {
            count++;
            System.out.println(count + " count " + Thread.currentThread().getName());
        }
    }
}