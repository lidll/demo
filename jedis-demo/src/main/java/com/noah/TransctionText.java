package com.noah;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @ClassName TransctionText
 * @Description TODO
 * @Author noah
 * @Date 3/18/21 2:56 PM
 * @Version 1.0
 **/
public class TransctionText {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","yangzheng");
        jsonObject.put("age",11);
        String s = jsonObject.toString();
        Transaction multi = jedis.multi();

        try {
            //开启事务
            multi.set("user1",s);
            multi.set("user2",s);
            multi.exec();

        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }


    }
}
