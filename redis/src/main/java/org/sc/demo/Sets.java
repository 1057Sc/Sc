package org.sc.demo;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Tuple;

import java.util.Calendar;
import java.util.Set;

public class Sets {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.0.20", 6379, 3000, "123456");


    @Test
    public void testSet() {
        Jedis jedis = pool.getResource();
        String key = "sad";
        Set<String> smembers = jedis.smembers(key);
        System.out.println(smembers.size());
        pool.close();
    }
}
