package concurrency.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {


    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void test1(){
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
    }
}
