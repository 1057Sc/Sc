package org.sc.lock;

import cn.hutool.json.JSONUtil;
import org.sc.common.JedisClient;

public class RedisLock {

    public static void main(String[] args) {
        RedisLock redisLock = new RedisLock();
        redisLock.multiThread();
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
        Runnable task = () -> JedisClient.getInstance().lock("foo", "bar", 3300);

    }
}
