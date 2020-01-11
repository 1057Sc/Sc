package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RList {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    @Test
    public void demo1(){
        Jedis jedis = pool.getResource();
        jedis.lpush("sc","Java");
    }
}
