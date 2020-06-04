package org.sc.demo;

import org.junit.Test;
import org.sc.doSelect.RedisExecute;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RList {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    @Test
    public void demo1() {
        Jedis jedis = pool.getResource();
        jedis.lpush("sc", "Java");
        jedis.lpop("sc");
    }

    @Test
    public void demo2() {
        Jedis jedis = pool.getResource();

        RedisExecute execute = jedis1 -> jedis1.set("dsad", "sad");

        jedis.select(1);
        execute.doJedis(jedis);
        jedis.close();

    }
}
