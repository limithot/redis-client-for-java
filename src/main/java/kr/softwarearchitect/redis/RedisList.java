package kr.softwarearchitect.redis;

import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * head is left, tail is right
 *
 * index number '-1' is last and -2 is left from last item
 *
 */
public class RedisList
{
    public RedisList(){}

    public void lpush(String key, String value)
    {
        JedisPool pool = RedisConnectionPool.getConnection();
        Jedis jedis = pool.getResource();

        jedis.lpush(key,value);

        jedis.close();
        pool.close();
    }

    public void lpush(Jedis  conn, String key, String value)
    {
        conn.lpush(key,value);
    }

    public String lpop(Jedis  conn, String key)
    {
        return conn.lpop(key);
    }

    public String lpop(String key)
    {
        String result = null;
        JedisPool pool = RedisConnectionPool.getConnection();
        Jedis jedis = pool.getResource();

        result = jedis.lpop(key);

        jedis.close();
        pool.close();

        return result;
    }
}
