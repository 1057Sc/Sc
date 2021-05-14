package concurrency.threadPool;

import com.sun.codemodel.internal.JTryBlock;
import com.sun.corba.se.impl.logging.InterceptorsSystemException;
import org.junit.Test;
import org.omg.SendingContext.RunTime;

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

    @Test
    public void test2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean interrupted = Thread.currentThread().isInterrupted();
        executorService.submit(() ->
                {
                    try {
                        System.out.println("213123213");
                 /*       synchronized (this) {
                            System.out.println("等待啊");
                            Thread.sleep(3000);
                            System.out.println("等待完了");
                        }*/
                        boolean shutdown = executorService.isShutdown();
                        System.out.println(shutdown);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
