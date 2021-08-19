package com.bjpowernode.jedis;

import com.bjpowernode.jedis.util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        /*Jedis jedis = new Jedis("192.168.209.128",6379);
        jedis.flushDB();
        String set = jedis.set("str1", "java");
        jedis.set("str2","php");
        jedis.zadd("student",60,"zhangsan");
        jedis.zadd("student",99,"lisi");
        jedis.zadd("student",85,"wangwu");
        Long size = jedis.zadd("student", 70, "zhaoliu");
        System.out.println(set);
        System.out.println(jedis.get("str1"));
        System.out.println(jedis.get("str2"));
        System.out.println(size);
        // 关闭资源
        jedis.close();

        // 创建一个连接池对象
        JedisPool jedisPool = RedisUtils.open("192.168.209.128", 6379);
        // 从连接池对象中获取一个Jedis对象
        Jedis jedis = jedisPool.getResource();
        HashMap<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","18");
        map.put("shengao","170");
        String result = jedis.hmset("set", map);
        System.out.println(result);

        Long lpush = jedis.lpush("list", "java", "php", "go", "python", "c");
        System.out.println(lpush);

        // 关闭连接池
        jedisPool.close();*/

        // 事务使用
        JedisPool jedisPool = RedisUtils.open("192.168.209.128", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB();
        // 开启事务
        Transaction multi = jedis.multi();
        multi.set("str1","aaa");
        multi.set("str2","bbb");
        List<Object> exec = multi.exec();
        for (Object o : exec) {
            System.out.println(o);
        }
    }
}
