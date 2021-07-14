package java8.sfuction;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author Sc
 * @date 2021/3/16
 */
@FunctionalInterface
public interface SFunction<T, R> extends Function<T, R>, Serializable {
}
