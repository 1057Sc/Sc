package org.sc.doSelect;

import redis.clients.jedis.Jedis;

public interface RedisExecute {
    Object doJedis(Jedis connection);
}
