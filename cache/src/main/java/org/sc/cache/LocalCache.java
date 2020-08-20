package org.sc.cache;


import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import org.junit.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * a practice of use Caffeine
 */
public class LocalCache {

    private Cache<Integer, Integer> fooCache = CacheBuilder.newBuilder()
            // 缓存刷新时间
            .expireAfterWrite(2, TimeUnit.SECONDS)
            // 设置缓存个数
            .maximumSize(2).build(new CacheLoader<Integer, Integer>() {
                @Override
                public Integer load(Integer key) throws Exception {
                    System.out.println("缓存刷新");
                    return key;
                }
            });


    private com.github.benmanes.caffeine.cache.Cache<String, Integer> cache = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .maximumSize(10_000)
            .build();


    @Test
    public void test() {
        try {

            System.out.println(fooCache.get(1, () -> 1));
            System.out.println(fooCache.get(2, () -> 2));
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public Integer getInt() {
        System.out.println("缓存1加载");
        Random random = new Random();
        return random.nextInt(20);
    }
}
