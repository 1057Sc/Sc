package org.sc.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Aspect {

    public void afterReturn(Object returnValue) throws Throwable {
        log.info("value return was {}",  returnValue);
    }
}
