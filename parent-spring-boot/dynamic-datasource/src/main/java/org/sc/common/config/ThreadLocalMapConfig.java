package org.sc.common.config;

import java.util.Objects;

/**
 * @author Sc
 * @date 2021/5/29
 */
public class ThreadLocalMapConfig {
    public static ThreadLocal threadLocal = new ThreadLocal();


    public static void set() {
        threadLocal.set("switch");
    }

    public static boolean needSwitch() {
        Object aSwitch = threadLocal.get();
        return Objects.nonNull(aSwitch) && aSwitch.toString().equals("switch");
    }
}
