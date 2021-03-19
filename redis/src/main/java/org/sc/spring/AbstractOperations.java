package org.sc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * @author zhuqingxin
 * @date 2021/3/15
 */
public abstract class AbstractOperations {
    // utility methods for the template internal methods
    public abstract class ValueDeserializingRedisCallbackCodeMao<V> implements RedisCallback<V> {

        private Object key;

        private Class<V> clazz;

        public ValueDeserializingRedisCallbackCodeMao(Object key, Class<V> clazz) {
            this.key = key;
            this.clazz = clazz;
      /*      template.setDefaultSerializer();
            template.setValueSerializer();*/
        }

        public final V doInRedis(RedisConnection connection) {
            byte[] result = inRedis(rawKey(key), connection);
            return deserializeValue(result, clazz);
        }

        @Nullable
        protected abstract byte[] inRedis(byte[] rawKey, RedisConnection connection);
    }

    @Autowired
    StringRedisTemplate template;

    RedisSerializer keySerializer() {
        return template.getKeySerializer();
    }

    RedisSerializer valueSerializer() {
        return template.getValueSerializer();
    }

    @Nullable
    <T> T execute(RedisCallback<T> callback, boolean exposeConnection) {
        return template.execute(callback, exposeConnection);
    }

    <V> V deserializeValue(byte[] value, Class<V> tClass) {
        if (valueSerializer() == null) {
            return (V) value;
        }
        return (V) valueSerializer().deserialize(value);
    }

    byte[] rawKey(Object key) {

        Assert.notNull(key, "non null key required");

        if (keySerializer() == null && key instanceof byte[]) {
            return (byte[]) key;
        }

        return keySerializer().serialize(key);
    }

    byte[][] rawValues(Object... values) {

        byte[][] rawValues = new byte[values.length][];
        int i = 0;
        for (Object value : values) {
            rawValues[i++] = rawValue(value);
        }

        return rawValues;
    }

    byte[] rawValue(Object value) {

        if (valueSerializer() == null && value instanceof byte[]) {
            return (byte[]) value;
        }

        return valueSerializer().serialize(value);
    }

}
