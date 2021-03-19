package org.sc.spring;

import java.io.Serializable;

/**
 * @author zhuqingxin
 * @date 2021/3/14
 */
public interface SetOperations {

    <K extends Serializable, V> Long add(K key, V... values);

    <K extends Serializable, V> V pop(K key, Class<V> vClass);
}
