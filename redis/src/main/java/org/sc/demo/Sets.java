package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class Sets {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.0.100.9");


    @Test
    public void testSet(){
        Jedis jedis = pool.getResource();
        String key = "sad";
        Set<String> smembers = jedis.smembers(key);
        System.out.println(smembers.size());
    }


}
