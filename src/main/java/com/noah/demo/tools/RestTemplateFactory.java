package com.noah.demo.tools;

import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateFactory
 * @Description TODO
 * @Author noah
 * @Date 2019-07-01 17:14
 * @Version 1.0
 **/
public class RestTemplateFactory {

    private static RestTemplate restTemplate;

    public static RestTemplate getRestTemplate(){
        if (restTemplate == null){
             return new RestTemplate();
        }else{
            return restTemplate;
        }
    }
}
