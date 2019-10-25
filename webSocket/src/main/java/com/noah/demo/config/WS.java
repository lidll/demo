package com.noah.demo.config;

import com.noah.demo.controller.WebSocketServer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName WS
 * @Description TODO
 * @Author noah
 * @Date 2019-10-25 11:35
 * @Version 1.0
 **/
public class WS {
    //新:使用map对象,便于根据userId来获取对应的WebSocket
    public static ConcurrentHashMap<String , WebSocketServer> socketMap = new ConcurrentHashMap<>();
}
