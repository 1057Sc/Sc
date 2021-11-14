package org.sc.spring;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author Sc
 * @date 2021/3/10
 */
public class RedisCacheSingleton {

    @Autowired
    private SetOperations setOps;

    public <K extends Serializable, V> V pop(K key, Class<V> clazz) {
        return setOps.pop(key, clazz);
    }

    public <K extends Serializable, V> Long add(K key, V... values) {
        return setOps.add(key, values);
    }

}
