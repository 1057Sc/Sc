package org.sc.spring;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Sc
 */
@Component
public class SetOperationsImpl extends AbstractOperations implements SetOperations {

    @Override
    public <K extends Serializable, V> Long add(K key, V... values) {
        byte[] rawKey = rawKey(key);
        byte[][] rawValues = rawValues((Object[]) values);
        return execute(connection -> connection.sAdd(rawKey, rawValues), true);
    }

    @Override
    public <K extends Serializable, V> V pop(K key, Class<V> vClass) {
        return execute(new ValueDeserializingRedisCallbackCodeMao<V>(key, vClass) {
            @Override
            protected byte[] inRedis(byte[] rawKey, RedisConnection connection) {
                return connection.sPop(rawKey);
            }
        }, true);
    }
}
