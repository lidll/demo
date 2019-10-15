package com.noah.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisDao
 * @Description TODO
 * @Author noah
 * @Date 2019-06-04 16:51
 * @Version 1.0
 **/
@Repository
//@PropertySource("classpath:redis.properties")
public class RedisDao {
    @Autowired
    private StringRedisTemplate template;

//    @Value("${redis.url}")
//    public String url;

    public void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = template.opsForValue();
        String s = ops.get(key);
        return s;
    }

//    public void jedisSetKey(String key,String value){
//        Jedis jedis = new Jedis(url);
//        jedis.setex(key,10,value);
//    }
//
//    public String jedisGetValue(String key){
//        Jedis jedis = new Jedis(url);
//        String s = jedis.get(key);
//        return s;
//    }
}
