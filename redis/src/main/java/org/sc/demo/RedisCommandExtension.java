package org.sc.demo;

import redis.clients.jedis.Jedis;

/**
 * @author zhuqingxin
 * @date 2021/3/3
 */
public class RedisCommandExtension extends Jedis {

    boolean lock(RedisKeyEnum key, String value) {
        // todo 锁实现
        return true;
    }
}
