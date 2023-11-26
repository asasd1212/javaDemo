package cn.tbs.test;

import cn.tbs.RedisApp;
import cn.tbs.until.jedisPoolUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import cn.tbs.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApp.class)
public class TS {
    Jedis jedis = new Jedis();
    public static void main(String[] args) {

    }
    @Test
    public void ts01(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("java","2023");
        System.out.println(jedis.get("java"));
        jedis.close();
    }
    @Test
    public void ts02(){

//2. 存储hash
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");


        String name = jedis.hget("user","name");
        System.out.println(name);

    }
    @Test
    public void ts03(){
        jedis.lpush("namex","张三","李四","王五");
        List<String> namex = jedis.lrange("namex", 0, -1);
        namex.forEach(System.out::println);
    }
    @Test
    public void ts04(){
        Jedis jedis = new Jedis();
    //2. 存储
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",55,"孙悟空");
        jedis.zadd("mysortedset",30,"后裔");

    //获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);

        System.out.println(mysortedset);
    //3. 关闭连接
        jedis.close();
    }
    @Test
    public void ts05(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);


        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        Jedis resource = jedisPool.getResource();
        resource.set("value","666");
        System.out.println(resource.get("value"));
    }
    @Test
    public void ts06(){
        Jedis jedis = jedisPoolUtil.getJedis();
        jedis.set("nickName", "dww");
        System.out.println("nickName");
    }

    @Test
    public void ts07(){
        Jedis jedis= jedisPoolUtil.getJedis();
        User user=new User(1,"张三","666");
        String jsonString = JSONObject.toJSONString(user);
        //存数据擦操作
        //设置数据到redis服务器
        jedis.set("user:1",jsonString);
        System.out.println(jedis.get("user:1"));

        //从redis服务器取数据操作
        //将字符串的格式转回Object类型;
        //parseObject(json字符串，User.class);
        User user2= JSONObject.parseObject(jedis.get("user:1"), User.class);
        System.out.println(user2);
        jedis.close();
        jedis.close();
    }

    @Test
    public void ts08(){
        Jedis jedis= jedisPoolUtil.getJedis();
        List<User> userList = Arrays.asList(new User(2,"万凯","888"),new User(3,"tom","989"));
        String jsonString = JSONArray.toJSONString(userList);
        //存数据到redis服务器
        jedis.set("userList",jsonString);
        System.out.println(jedis.get("userList"));
        //将字符串转回 来;
        String str=jedis.get("userList");

        //从redis服务器取数据操作;
        List<User>list= JSONArray.parseArray(str, User.class);
        //lambda方式;
        list.forEach(System.out::println);


        jedis.close();
    }
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void ts09(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("str","String test");
        System.out.println(valueOperations.get("str"));
    }

    @Test
    public void ts10(){
        List<User> userList = Arrays.asList(new User(2,"smith","99999"),new User(3,"king","kkkk"));
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set("userlist",userList);
        System.out.println(opsForValue.get("userlist"));
    }
}
