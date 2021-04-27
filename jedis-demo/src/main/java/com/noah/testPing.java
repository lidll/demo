package com.noah;

import redis.clients.jedis.Jedis;

/**
 * @ClassName testPing
 * @Description TODO
 * @Author noah
 * @Date 3/18/21 2:43 PM
 * @Version 1.0
 **/
public class testPing {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
    }
}
