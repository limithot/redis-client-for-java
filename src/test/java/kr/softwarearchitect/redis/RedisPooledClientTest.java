package kr.softwarearchitect.redis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.invoke.MethodHandles;

public class RedisPooledClientTest
{
    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testPooledPushAndPop()
    {
        RedisList list= new RedisList();
        list.lpush("myKey", "myValue");
        LOG.debug( list.lpop("myKey"));

        list.lpush("myKey2", "myValue2");
        LOG.debug( list.lpop("myKey2"));
    }
}
