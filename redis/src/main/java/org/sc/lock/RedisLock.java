package org.sc.lock;

import cn.hutool.json.JSONUtil;
// import org.sc.common.JedisClient;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedisLock {

   /* public static void main(String[] args) {
        RedisLock redisLock = new RedisLock();
        // redisLock.multiThread();
        redisLock.multiThread2();
    }

    public void multiThread() {
        Runnable runnable = () -> System.out.println(JedisClient.getInstance());
        Runnable runnable2 = () -> System.out.println(JedisClient.getInstance());

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable2);

        thread.start();
        thread1.start();
    }

    public void multiThread1() {
        Runnable task = () -> {
            System.out.println(JedisClient.getInstance().lock("foo", "bar", 3300));
        };

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(task);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }


    public void multiThread2() {
        Jedis jedis = JedisClient.getInstance().getJedis();
        for (int i = 0; i < 5; i++) {
            System.out.println(jedis.set("bar", "foo"));
        }
        jedis.close();
    }*/
}

