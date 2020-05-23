package concurrency.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {


    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void test1() {

        for (int i = 0; i < 5; i++) {

            int l = i;
            executorService.submit(() -> {
                System.out.println(1213123213);
                return l;
            });
        }

        // executorService.shutdown();
    }
}
