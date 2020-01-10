package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * https://www.tutorialspoint.com/redis/redis_sorted_sets.htm
 */
public class SortedSet {
    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    @Test
    public void demo1() {
        Jedis jedis = pool.getResource();
        String key = "sc";
        jedis.zadd("sc", 100, "Java");
        jedis.zcount(key, 0, 3);
        jedis.zrange(key, 0, -2);
    }
}
