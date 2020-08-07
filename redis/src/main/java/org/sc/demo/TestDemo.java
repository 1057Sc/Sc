package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestDemo {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.0.9");

    @Test
    public void demo1() {
        try (Jedis resource = pool.getResource()) {
            String sadsa = resource.spop("sadsa");
            System.out.println(sadsa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
