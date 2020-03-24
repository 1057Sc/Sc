package concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DoFutures {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static Future<Integer> demo1(Integer i){
        return executorService.submit(() -> {
            Thread.sleep(1000);
            return i * i;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Using isDone() and get() to Obtain Results
        Future<Integer> integerFuture = demo1(1);
        boolean done = demo1(2).isDone();
        Integer integer = integerFuture.get();
        System.out.println(integer);

        // Canceling a Future with cancel()
        boolean cancel = demo1(3).cancel(true);
        executorService.shutdown();
    }
}
