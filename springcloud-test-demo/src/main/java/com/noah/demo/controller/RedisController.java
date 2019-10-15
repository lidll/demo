package com.noah.demo.controller;

import com.noah.demo.domain.DTO.HttpResponseDTO;
import com.noah.demo.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisController
 * @Description TODO
 * @Author noah
 * @Date 2019-06-04 17:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisDao redisDao;
    @GetMapping("/setKey")
    public HttpResponseDTO setKey(@RequestParam("key")String key,@RequestParam("value")String value){
        redisDao.setKey(key,value);
        return HttpResponseDTO.success();
    }
}
