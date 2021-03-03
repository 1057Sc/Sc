package org.sc.demo;

/**
 * redis行为描述 例如描述用RedisCommandExtension干什么，用来传递行为。
 *
 * @param <T>
 */
@FunctionalInterface
public interface RedisExecute<T> {

    T execute(RedisCommandExtension connection);

}
