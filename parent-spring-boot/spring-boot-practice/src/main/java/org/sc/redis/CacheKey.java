package org.sc.redis;

/**
 * 缓存key定义，实现可以用来作为定义redis的key、本地缓存key等
 */
public interface CacheKey {

    String buildKey();

    String buildKey(String... keyElement);

    Long getExpire();

}