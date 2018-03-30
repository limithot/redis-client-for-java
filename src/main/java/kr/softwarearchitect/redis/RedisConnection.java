package kr.softwarearchitect.redis;

import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

public class RedisConnection
{
    private Connection conn = null;
    private Jedis jedis = null;
    public RedisConnection(){}

    public Connection getConnection(String host, int port)
    {
        this.conn = new Connection();
        this.conn.setHost(host);
        this.conn.setPort(port);
        this.conn.connect();
        return this.conn;
    }

    public Jedis getJedis(String host, int port)
    {
        this.jedis = new Jedis(host , port);
        this.jedis.connect();
        return this.jedis;
    }

    public void disConnectJedis()
    {
        this.jedis.disconnect();
    }

    public void disconnect()
    {
        this.conn.disconnect();
    }
}
