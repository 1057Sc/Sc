package org.sc.spring;

import java.io.Serializable;

/**
 * @author Sc
 * @date 2021/3/14
 */
public interface SetOperations {

    <K extends Serializable, V> Long add(K key, V... values);

    <K extends Serializable, V> V pop(K key, Class<V> vClass);
}
