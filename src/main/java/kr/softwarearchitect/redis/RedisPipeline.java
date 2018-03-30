package kr.softwarearchitect.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

public class RedisPipeline
{
    private JedisPool pool;
    private Jedis jedis;

    public RedisPipeline(){}

    public Pipeline getPipeline()
    {
        this.pool = RedisConnectionPool.getConnection();
        this.jedis = this.pool.getResource();
        return this.jedis.pipelined();
    }

    public void commit()
    {
        this.jedis.close();
        this.pool.close();
    }
}
