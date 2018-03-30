package kr.softwarearchitect.redis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.lang.invoke.MethodHandles;

public class RediSimpleClientTest
{
    private static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testPushPop()
    {
        RedisConnection conn = new RedisConnection();
        Jedis jedis = conn.getJedis("172.30.1.27", 6379);

        RedisList list = new RedisList();
        list.lpush(jedis, "myKey", "myValue");
        String result = list.lpop("myKey");
        LOG.debug( result );

        conn = new RedisConnection();
        jedis = conn.getJedis("172.30.1.27", 6379);

        list = new RedisList();
        list.lpush(jedis, "myKey2", "myValue2");
        result = list.lpop("myKey2");
        LOG.debug( result );
    }


}
