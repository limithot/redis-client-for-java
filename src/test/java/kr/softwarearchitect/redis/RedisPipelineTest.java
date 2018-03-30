package kr.softwarearchitect.redis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class RedisPipelineTest
{
    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testPipelined()
    {
        RedisPipeline rppl = new RedisPipeline();
        Pipeline  ppl = rppl.getPipeline();


        ppl.rpush("myList","1");
        ppl.rpush("myList","2");
        ppl.rpush("myList","3");
        ppl.rpush("myList","4");


        Response<List<String>> res = ppl.lrange("myList", 0 , -1);
        Response<String> myFirst = ppl.lpop("myList");
        ppl.ltrim("myList", 0, 3);
        Response<List<String>> res2 = ppl.lrange("myList", 0 , -1);

        ppl.del("myList");
        ppl.sync();
        rppl.commit();

        LOG.debug(res.get().toString());
        LOG.debug(res2.get().toString());
        LOG.debug(myFirst.get().toString());
    }
}
