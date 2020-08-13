package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;

public class TestDemo {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");

    @Test
    public void demo1() {
        try (Jedis resource = pool.getResource()) {
            String sadsa = resource.spop("sadsa");
            System.out.println(sadsa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo2() {
        try (Jedis resource = pool.getResource()) {
            String zSetKey = "scsc1";
            long score = 1;
            String member = "124";
            Double timeSign = 1 - (new Date().getTime()) / 100000000000000d;
            Double currentScore = resource.zincrby(zSetKey, score, member);
            Double dif = timeSign - (currentScore - currentScore.intValue());
            System.out.println(resource.zincrby(zSetKey, dif, member));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 1.9840268878862402
    // 1.98402688767237
}
