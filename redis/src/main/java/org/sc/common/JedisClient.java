package org.sc.common;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

@Slf4j
public class JedisClient {

    private static JedisPool pool = null;

    private static class Singleton {

        private static JedisClient client;

        static {
            client = new JedisClient();
        }

        private static JedisClient getInstance() {
            return client;
        }
    }


    public static JedisClient getInstance() {
        return Singleton.getInstance();
    }

    private JedisClient() {
        if (pool == null) {
            pool = new JedisPool(new JedisPoolConfig(), "10.0.100.235");
        }

        log.info("jedis client init {}", this);
        System.out.println("jedis client init ");
    }

    private Jedis getJedis() throws RuntimeException {
        Jedis jedis = null;

        if (pool != null) {
            jedis = pool.getResource();
        }

        return jedis;
    }

    public boolean lock(String key, String value, long expire) {
        if (key == null) {
            throw new IllegalArgumentException("The key must not be null");
        } else {
            Jedis jedis = null;

            try {
                jedis = this.getJedis();
                SetParams setParams = new SetParams();
                setParams.nx();
                expire = expire == 0L ? 5000L : expire;
                setParams.px(expire);
                String result = jedis.set(key, value, setParams);
                boolean var8 = "OK".equals(result);
                return var8;
            } catch (Exception var12) {
                log.error("", var12);
            } finally {
                this.close(jedis);
            }

            return false;
        }
    }

    public void close(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }

    }
}
