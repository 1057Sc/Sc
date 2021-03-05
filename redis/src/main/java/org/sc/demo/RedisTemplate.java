package org.sc.demo;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 这里是一个扩展点，例如可以用redisson jedis 等等
 */
@Component
public class RedisTemplate {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    public <T> T execute(RedisExecute<T> redisExecute) {
        RedisCommandExtension redisCommandExtension = new RedisCommandExtension();
        return redisExecute.execute(redisCommandExtension);
      /*  try (Jedis jedis = pool.getResource()) {
            redisExecute
            return redisExecute.execute(jedis);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }*/
    }
}
