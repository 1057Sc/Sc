package concurrency.future;


import java.util.concurrent.*;

public class FutureDemo {

    public String invoke() {

        String str = null;

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(1000);
            return "Hello Future!";
        });

        // future.cancel(false);

        try {
            future.get(20, TimeUnit.SECONDS);
            // future.get();
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
        // } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        if (future.isDone() && !future.isCancelled()) {
            try {
                str = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }finally {
                executor.shutdown();
            }
        }

        return str;
    }

    public static void main(String[] args) {
        FutureDemo futureDemo = new FutureDemo();
        String invoke = futureDemo.invoke();
        System.out.println(invoke);
    }
}
