package kr.softwarearchitect.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 *
 */
public class RedisConnectionPool
{

    /**
     *
     */
    private RedisConnectionPool()
    {
    }

    public static JedisPool getConnection()
    {
        return Singleton.HOLDER.jedisPool();
    }

    /**
     *
     */
    private JedisPool jedisPool()
    {
        final JedisPoolConfig poolConfig = buildPoolConfig();
        /* simple connection configuration*/
        JedisPool jedisPool = new JedisPool(poolConfig, "172.30.1.27");
        return jedisPool;
    }

    /**
     *
     */
    private JedisPoolConfig buildPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }


    /**
     * Singleton Class that has HOLDER
     */
    private static final class Singleton
    {
        private final static RedisConnectionPool HOLDER = new RedisConnectionPool();
    }
}

