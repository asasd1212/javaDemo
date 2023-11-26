package cn.tbs.until;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class jedisPoolUtil {
    private static JedisPool jedisPool;
    static {
        InputStream resourceAsStream = jedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
        int maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));
        String host = properties.getProperty("host");
        int port = Integer.parseInt(properties.getProperty("port"));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        System.out.println(host+port);
        jedisPool = new JedisPool(jedisPoolConfig,host,port);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
