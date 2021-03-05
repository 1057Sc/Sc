package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class RList {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    @Test
    public void demo1() {
        Jedis jedis = pool.getResource();
        jedis.lpush("sc", "Java");
        jedis.lpop("sc");
    }

    @Test
    public void set() {
        String key = RedisKeyEnum.SET_DEMO.buildKey("foo");
        String execute1 = execute(jedis -> jedis.set(key, "bar"));
        System.out.println(execute1);
    }

    @Test
    public void demo3() {
        Jedis jedis = pool.getResource();
        List<String> dasdsa = jedis.lrange("dasdsa", 0, -1);
        System.out.println(dasdsa);
    }

    private <T> T execute(RedisExecute<T> redisExecute) {
        Jedis jedis = pool.getResource();
        // jedis.select(1);
        return redisExecute.execute(jedis);
    }
}
