package com.noah.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName RedisUtils
 * @Description TODO
 * @Author noah
 * @Date 4/8/21 4:06 PM
 * @Version 1.0
 **/
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;
}
