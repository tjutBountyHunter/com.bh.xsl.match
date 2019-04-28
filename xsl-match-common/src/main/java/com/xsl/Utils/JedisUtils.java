package com.xsl.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 20:32
 * @Description:
 */
public class JedisUtils {

    private static JedisPool jedisPool;

    @Autowired
    public void setJedisPool(JedisPool jedisPool) {
        JedisUtils.jedisPool = jedisPool;
    }

    public static String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    public static String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    public static String setEx(String key, String value, Integer time) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value, "nx", "ex", time);
        jedis.close();
        return string;
    }

    public static String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    public static long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(hkey, key, value);
        jedis.close();
        return result;
    }

    public static long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    public static long expire(String key, long second) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.expire(key, (int) second);
        jedis.close();
        return result;
    }

    public static long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    public static long delete(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.del(key);
        jedis.close();
        return result;
    }

    public static long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }

    public static Set<String> keys(String prefix){
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys(prefix + "*");
        jedis.close();
        return keys;
    }

}
