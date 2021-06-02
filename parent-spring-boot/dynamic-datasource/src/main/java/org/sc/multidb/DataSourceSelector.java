package org.sc.multidb;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.sc.multidb.MultiDbConstants.*;

public class DataSourceSelector {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceSelector.class);

    private static ThreadLocal<String> currentKey = new ThreadLocal<>();

    public static String getCurrentKey() {
        String key = currentKey.get();
        if (StringUtils.isNotEmpty(key))
            return key;
        else return RW;
    }

    public static void setRO() {
        setCurrenKey(RO);
    }

    public static void setRW() {
        setCurrenKey(RW);
    }

    public static void setWO() {
        setCurrenKey(WO);
    }

    public static void setCurrenKey(String key) {
        if (Arrays.asList(RO, WO, RW).indexOf(key) >= 0) {
            currentKey.set(key);
        } else {
            currentKey.set(RW);
            logger.warn("undefined key:" + key);
        }
    }
}
