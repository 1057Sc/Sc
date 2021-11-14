package org.sc.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * redis使用案例
 */
public class RedisCaseDemo {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set() {
        Long execute = redisTemplate.execute(jedis -> jedis.setnx(RedisKeyEnum.SET_DEMO.buildKey("foo"), "bar"));
        System.out.println(execute);
    }

    @Test
    public void hash() {
        Long execute = redisTemplate.execute(jedis -> jedis.hset(RedisKeyEnum.HASH_DEMO.buildKey("foo"), "foo_field", "bar"));
        System.out.println(execute);
        String execute1 = redisTemplate.execute(jedis -> jedis.hget(RedisKeyEnum.HASH_DEMO.buildKey("foo"), "foo_field"));
        System.out.println(execute1);
    }

    @Test
    public void string() {
        String execute = redisTemplate.execute(jedis -> jedis.set(RedisKeyEnum.STRING_DEMO.buildKey("foo"), "bar"));
        System.out.println(execute);
        String foo = redisTemplate.execute(jedis -> jedis.set(RedisKeyEnum.STRING_DEMO.buildByteKey("foo_byte"), "bar".getBytes()));
        System.out.println(foo);
    }

    @Test
    public void list() {
        Long execute = redisTemplate.execute(jedis -> jedis.lpush(RedisKeyEnum.LIST_DEMO.buildKey("foo"), "bar"));
        System.out.println(execute);
        String foo = redisTemplate.execute(jedis -> jedis.lpop(RedisKeyEnum.LIST_DEMO.buildKey("foo")));
        System.out.println(foo);

        // Boolean execute1 = redisTemplate.execute(jedis -> jedis.lock(RedisKeyEnum.LIST_DEMO, "123"));
    }


}
