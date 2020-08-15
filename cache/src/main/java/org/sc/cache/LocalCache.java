package org.sc.cache;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * a practice of use Caffeine
 */
public class LocalCache {

    private Cache<Integer, Integer> awardCache = CacheBuilder.newBuilder()
            // 缓存刷新时间
            .expireAfterWrite(5, TimeUnit.SECONDS)
            // 设置缓存个数
            .maximumSize(2).build();

    @Test
    public void test() {
        try {

            System.out.println(awardCache.get(1, this::getInt));
            System.out.println(awardCache.get(2, this::getInt));
            Thread.sleep(6);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public Integer getInt() {
        System.out.println("缓存加载");
        Random random = new Random();
        return random.nextInt(20);
    }
}
