package org.sc.redis;

import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.Objects;

/**
 * 扩展redisRedisTemplate
 */
public class RedisTemplateExtension extends RedisTemplate<String, Object> {

    /**
     * 释放锁lua脚本
     */
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";


    public RedisTemplateExtension(RedisConnectionFactory connectionFactory) {
        setConnectionFactory(connectionFactory);
        afterPropertiesSet();
    }

    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        return new DefaultStringRedisConnection(connection);
    }

    public boolean lock(RedisKeyEnum keyEnum, Object lockValue) {
        return Boolean.TRUE.equals(super.opsForValue().setIfAbsent(keyEnum.buildKey(), lockValue, keyEnum.getExpire(), keyEnum.getTimeUnit()));
    }

    public boolean unlock(RedisKeyEnum keyEnum, Object lockValue) {
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        return Objects.equals(1L, super.execute(redisScript, Collections.singletonList(keyEnum.buildKey()), lockValue));
    }
}
