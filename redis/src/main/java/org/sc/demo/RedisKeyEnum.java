package org.sc.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

/**
 * 统一Redis key定义
 *
 * @author zhuqingxin
 * @date 2021/2/24
 */
@AllArgsConstructor
@Getter
public enum RedisKeyEnum implements CacheKey {
    HASH_DEMO("hash_demo", 1000L, "redis使用案例", KeyType.HASH),
    SET_DEMO("set_demo", 1000L, "redis使用案例", KeyType.SET),
    STRING_DEMO("string_demo", 1000L, "redis使用案例", KeyType.STRING),
    LIST_DEMO("list_demo", 1000L, "redis使用案例", KeyType.LIST),
    ;


    private String key;

    private Long expire;

    private String desc;

    private KeyType type;

    private TimeUnit timeUnit = TimeUnit.SECONDS;

    RedisKeyEnum(String key, Long expire, String desc, KeyType type) {
        this.key = key;
        this.expire = expire;
        this.desc = desc;
        this.type = type;
    }

    private enum KeyType {
        HASH,
        SET,
        STRING,
        SORTED_SET,
        LIST;
    }

    public String buildKey(String... keyElement) {
        StringBuffer key = new StringBuffer(this.getKey()).append("_");
        for (String element : keyElement) {
            key.append(element);
        }
        return key.toString();
    }

    public byte[] buildByteKey(String... keyElement) {
        StringBuffer key = new StringBuffer(this.getKey()).append("_");
        for (String element : keyElement) {
            key.append(element);
        }
        return key.toString().getBytes();
    }

    public String buildKey() {
        StringBuffer key = new StringBuffer(this.getKey()).append("_").append("213");
        return key.toString();
    }

    public byte[] buildByteKey() {
        StringBuffer key = new StringBuffer(this.getKey()).append("_").append("213");
        return key.toString().getBytes();
    }


}
