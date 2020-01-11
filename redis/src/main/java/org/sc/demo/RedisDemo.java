package org.sc.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Set;

public class RedisDemo {

    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
    public static void main(String args[]){
        //JedisPool pool = new JedisPool(new JedisPoolConfig(),"192.168.109.128");
        init1();
    }

    public static void init(){
        // try-with-resource
        JedisPool pool = new JedisPool(new JedisPoolConfig(),"10.0.100.235");
        /// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
        try(Jedis jedis = pool.getResource()){
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

    public static void init1(){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.set("Sc","1057");
            String foobar1 = jedis.get("foo1");
            System.out.println(foobar1);
            jedis.zadd("sose", 0, "car"); jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        }finally{
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

    public static void demo3(){
        Jedis jedis = null;
        jedis = pool.getResource();
        //jedis.hset("studeny".getBytes(),"name",);
    }

    public static void demo4(String fileLengthKey, String fileDataKey, String field, long blockSize){
        Jedis jedis = null;
        try{
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
    public void demo5(){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Pipeline pipelined = jedis.pipelined();
            // the same with Jedis api
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }
}
