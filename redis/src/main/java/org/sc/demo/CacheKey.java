package org.sc.demo;

/**
 * @author Sc
 * @date 2021/3/3
 */
public interface CacheKey {

    String buildKey();

    String buildKey(String... keyElement);

    Long getExpire();

}
