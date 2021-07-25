package lang.threadlocal;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadDemo1 {

    @Test
    public void demo() throws InterruptedException {

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.offer("1");
        linkedBlockingQueue.offer("2");
        linkedBlockingQueue.offer("3");
        linkedBlockingQueue.offer("4");
        linkedBlockingQueue.offer("5");


        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("====召唤神龙");
        });

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                String task = task(linkedBlockingQueue.poll());
                System.out.println("task ==> " + task);
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                String task1 = task(linkedBlockingQueue.poll());
                System.out.println("task ==> " + task1);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("线程间的结束");
            });

            thread.start();
            // thread.join();
        }
    }


    private String task(String name) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return name;
    }
}
