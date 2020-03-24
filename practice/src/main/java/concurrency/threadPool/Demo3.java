package concurrency.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * asynchronized
 */
public class Demo3 {

    public static int _count = 0;


    @Test
    public void test() {

        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(finalI);
            });
        }
    }


    @Test
    public void test1() {
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            executorService.submit(() -> {
                _count++;
                System.out.println(finalI);
            });
        }

        System.out.println("_count:::::::::::::" + _count);
    }
}
