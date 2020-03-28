package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.*;
import redis.clients.jedis.params.ZAddParams;

import java.util.Date;
import java.util.Set;


/**
 * https://www.tutorialspoint.com/redis/redis_sorted_sets.htm
 */
public class SortedSet {
    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.0.100.9");

    @Test
    public void demo1() {
        Jedis jedis = pool.getResource();
        String key = "sc";
        jedis.zadd("sc", 100, "Java");
        jedis.zcount(key, 0, 3);
        jedis.zrange(key, 0, -2);

        jedis.zadd("sc", 1000, "Java");

        Long sc = jedis.zcard("sc");

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

    @Test
    public void demo2() {
        Jedis jedis = pool.getResource();
        String key = "scscsc";

        jedis.del(key);
        jedis.unlink(key);

        Set<String> zrange1 = jedis.zrange(key, -10, -1);

        ZAddParams zAddParams = new ZAddParams();
        zAddParams.nx();
        jedis.zadd(key, new Date().getTime(), "faker", zAddParams);
        jedis.zadd(key, 1, "faker", zAddParams);
        jedis.zadd(key, 2, "faker1", zAddParams);
        jedis.zadd(key, 3, "faker2", zAddParams);
        jedis.zadd(key, 4, "faker3", zAddParams);
        jedis.zadd(key, 5, "faker4", zAddParams);

        Long zcard = jedis.zcard(key);
        Set<String> zrevrange = jedis.zrevrange(key, zcard - 20, zcard);
        zrevrange.stream().forEach(System.out::println);
        jedis.close();

        Set<String> zrange = jedis.zrange(key, -10, -9);
        System.out.println(zrange.toString());

        Set<String> zrevrange1 = jedis.zrevrange(key, -10, -1);
        System.out.println(zrevrange1.toString());



        //jedis.zrem(key, zrevrange.toArray(new String[zrevrange.size()]));
    }
}
