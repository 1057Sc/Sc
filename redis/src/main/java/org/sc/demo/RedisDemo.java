package org.sc.demo;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Date;
import java.util.Set;

public class RedisDemo {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    public static void main(String args[]) {
        //JedisPool pool = new JedisPool(new JedisPoolConfig(),"192.168.109.128");
        init1();
    }

    public static void init() {
        // try-with-resource
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.0.100.235");
        /// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
        try (Jedis jedis = pool.getResource()) {
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.set("foo1", "bar");
            String foobar1 = jedis.get("foo1");
            System.out.println(foobar1);
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
            //jedis.set()
        }
        /// ... when closing your application:
        pool.close();
    }

    public static void init1() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.set("Sc", "1057");
            String foobar1 = jedis.get("foo1");
            System.out.println(foobar1);
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        } finally {
            // You have to close jedis object. If you don't close then
            // it doesn't release back to pool and you can't get a new
            // resource from pool.
            if (jedis != null) {
                jedis.close();
            }
        }
/// ... when closing your application:
        pool.close();
    }

    public static void demo3() {
        Jedis jedis = null;
        jedis = pool.getResource();
        //jedis.hset("studeny".getBytes(),"name",);
    }

    public static void demo4(String fileLengthKey, String fileDataKey, String field, long blockSize) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Pipeline pipelined = jedis.pipelined();
            //delete file length
            pipelined.hdel(fileLengthKey.getBytes(), field.getBytes());
            //delete file content
            /*for (int i = 0; i < blockSize; i++) {
                byte[] blockName = getBlockName(field, i);
                pipelined.hdel(fileDataKey.getBytes(), blockName);
            }*/
            pipelined.sync();
        } finally {
            jedis.close();
        }
    }

    @Test
    public void demo5() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Pipeline pipelined = jedis.pipelined();
            // the same with Jedis api
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    //
    //30.9839925970079
    //60.98399259682201

    // 30.259231
    // 60.259207
    // 30063.394936
    // 30093.394572

    @Test
    public void demo6() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String zSetKey = "foo:time:stamp";
            String member = "bar";
            double score = 3;
            int i = 10;

            for (int i1 = 0; i1 < i; i1++) {
                Double timeSign = 1 - (getTimeStamp(0)) / 1E+10d;
                Double currentScore = jedis.zincrby(zSetKey, score, member);
                Double dif = timeSign - (currentScore - currentScore.intValue());
                jedis.zincrby(zSetKey, dif, member);
                jedis.zincrby(zSetKey, 0.0001, member);
            }
            // the same with Jedis api
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }


    @Test
    public void demo7() {
        getTimeStamp(0);
    }

    public long getTimeStamp(int offset) {
        long time = DateUtil.offsetDay(new Date(), offset).getTime() / 1000;
        String s = String.valueOf(time);
        String substring = s.substring(s.length() - 6);
        System.out.println(substring);
        return Long.parseLong(substring);
    }

   /* public double getDoubleByIndex(double demo, int revIndex) {
        String s = String.valueOf(demo);
        s.substring(demo, revIndex);
    }*/

    @Test
    public void demo8() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String key = "sad";
            // jedis.zincrby(key, 3, "bar");
            // jedis.zincrby(key, 1.0E-4, "bar");*/
            jedis.zincrby(key, 3 / 10000d, "bar");
            System.out.println(1);
            // the same with Jedis api
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    @Test
    public void demo9() {
        int a = 1234;

        int a1 = a / 10;
        System.out.println(a1);
    }

    @Test
    public void demo() {
        double s = 2.0000000245554E7;
        double s1 = 0.24553800000000003;

        double v = s - (int) s;

        System.out.println(v);
        System.out.println(s1 - v);

        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Pipeline pipelined = jedis.pipelined();
            // the same with Jedis api
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }


    @Test
    public void demo10() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            int i = 10000;
            long time1 = System.currentTimeMillis();
            for (int i1 = 0; i1 < i; i1++) {
                jedis.zincrby("foo123", i, String.valueOf(i1));
            }
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }


    @Test
    public void demo11() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            int i = 10000;
            long time1 = System.currentTimeMillis();
            Set<Tuple> foo123 = jedis.zrevrangeWithScores("foo123", 0, -1);
            System.out.println(foo123.size());
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }


    //
    //0.123124324324
    // 1231414324.1231244
    //1231414324
    @Test
    public void demo12() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            int i = 10000;
            long time1 = System.currentTimeMillis();
            jedis.zincrby("foo123123", 1231414324, String.valueOf(1123));
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
