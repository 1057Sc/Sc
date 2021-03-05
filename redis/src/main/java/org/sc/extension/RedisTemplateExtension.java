package org.sc.extension;

import org.sc.demo.RedisKeyEnum;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;

/**
 * @author zhuqingxin
 * @date 2021/3/4
 */
public class RedisTemplateExtension extends RedisTemplate<String, Object> {

    /**
     * 释放锁lua脚本
     */
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    /**
     * Constructs a new <code>StringRedisTemplate</code> instance ready to be used.
     *
     * @param connectionFactory connection factory for creating new connections
     */
    public RedisTemplateExtension(RedisConnectionFactory connectionFactory) {
        setConnectionFactory(connectionFactory);
        afterPropertiesSet();
    }

    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        return new DefaultStringRedisConnection(connection);
    }

    public Boolean lock(RedisKeyEnum keyEnum, Object lockValue) {
        return super.opsForValue().setIfAbsent(keyEnum.buildKey(), lockValue, keyEnum.getExpire(), keyEnum.getTimeUnit());
    }

    public void unlock(RedisKeyEnum keyEnum, Object lockValue) {
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long execute = super.execute(redisScript, Collections.singletonList(keyEnum.buildKey()), lockValue);
        System.out.println(execute);
    }
}
