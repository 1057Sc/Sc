package org.sc.multidb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OPCountMapper {
    private Map<String, Integer> countMapper = new ConcurrentHashMap<>();
    private Map<String, Integer> lastRouter = new ConcurrentHashMap<>();

    public OPCountMapper() {
        countMapper.put(RO, 0);
        countMapper.put(RW, 0);
        countMapper.put(WO, 0);
        lastRouter.put(RO, 0);
        lastRouter.put(RW, 0);
        lastRouter.put(WO, 0);
    }

    public String getCurrentRouter(String key) {
        int total = countMapper.get(key);
        if (total == 0) {
            if (!key.equals(RW))
                return getCurrentRouter(RW);
            else {
                return null;
            }
        }
        int last = lastRouter.get(key);
        return key + "_" + (last + 1) % total;
    }


    public String appendRo() {
        return appendKey(RO);
    }

    public String appendWo() {
        return appendKey(WO);
    }

    public String appendRw() {
        return appendKey(RW);
    }

    private String appendKey(String key) {
        int total = countMapper.get(key);
        String sk = key + "_" + total++;
        countMapper.put(key, total);
        return sk;
    }
}
