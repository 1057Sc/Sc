package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.*;


/**
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

        jedis.zadd("sc", 1000, "Java");
    }

 /*   @Test
    public void demo2() {
        Jedis jedis = JedisClient.getInstance().getJedis();
        for (int i = 0; i < 5; i++) {
            jedis.zadd("foo" + i, i, "bar" + i);
        }
        ScanResult<Tuple> foo1 = jedis.zscan("foo1", "10");
        List<Tuple> result = foo1.getResult();
        result.forEach(System.out::println);
    }*/
}
