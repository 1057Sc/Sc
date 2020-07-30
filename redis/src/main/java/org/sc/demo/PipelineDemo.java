package org.sc.demo;

import redis.clients.jedis.*;

public class PipelineDemo {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        Jedis jedis = pool.getResource();
        try {

            String key = "scsc";
            jedis.set(key, key);
            Pipeline pipelined = jedis.pipelined();
            // Boolean aBoolean = exists.get();
            pipelined.sync();
        } catch (Exception e) {
            jedis.close();
        }
    }
}
