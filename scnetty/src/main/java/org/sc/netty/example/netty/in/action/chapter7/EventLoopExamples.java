package org.sc.netty.example.netty.in.action.chapter7;

import java.util.Collections;
import java.util.List;

/**
 * isting 7.1 Executing tasks in an event loop
 *
 */
public class EventLoopExamples {
    public static void executeTaskInEventLoop() {
        boolean terminated = true;
        //...
        while (!terminated) {
            List<Runnable> readyEvents = blockUntilEventsReady();
            for (Runnable ev: readyEvents) {
                ev.run();
            }
        }
    }

    private static final List<Runnable> blockUntilEventsReady() {
        return Collections.<Runnable>singletonList(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}