package com.noah.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.noah.demo.dto.TalkDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName WsController
 * @Description TODO
 * @Author noah
 * @Date 2019-10-18 09:52
 * @Version 1.0
 **/
@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketServer {

    private static Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //旧：concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//    private static CopyOnWriteArraySet<WebSocketServer> webSokcetSet = new CopyOnWriteArraySet<WebSocketServer>();

    //新:使用map对象,便于根据userId来获取对应的WebSocket
    private static ConcurrentHashMap<String ,WebSocketServer> socketMap = new ConcurrentHashMap<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //接收sid
    private String userId = "";
    /**
     *
     * @Author yz
     * @Description 连接建立成功调用的方法
     * @Date 2019-10-18 09:55
     * @param session
     * @param userId
     * @return void
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId){
        try {
        this.session = session;
        socketMap.put(userId,this);
        addOnlineCount();
        log.info("有新窗口开始监听:" + userId + ",当前在线人数为" + getOnlineCount());
        this.userId = userId;
        sendMessage(JSON.toJSONString(TalkDTO.success()));
        } catch (Exception e) {
            log.info("webSocket IO异常");
        }
    }

    /**
     *
     * @Author yz
     * @Description 连接关闭调用的方法
     * @Date 2019-10-18 09:56
     * @param
     * @return void
     */
    @OnClose
    public void onClose(){
        if (socketMap.get(this.userId) != null) {
            socketMap.remove(userId);
        }
        //在线人数减1
        subOnlineCount();
        log.info("有一连接关闭!当前在线人物为" + getOnlineCount());
    }

    /**
     *
     * @Author yz
     * @Description 收到客户端消息后调用的方法
     * @Date 2019-10-18 09:57
     * @param message
     * @param session
     * @return void
     */
    @OnMessage
    public void onMessage(String  message,Session session){
        log.info("转发端收到来自用户" +userId+ "的消息:" +message);
        if(StringUtils.isNotBlank(message)){
            JSONArray list= JSONArray.parseArray(message);
            for (int i = 0; i < list.size(); i++) {
                try {
                    //解析发送的报文
                    TalkDTO talkDTO = list.getJSONObject(i).toJavaObject(TalkDTO.class);
                    talkDTO.setFromUserId(this.userId);
                    //传送给对应用户的websocket
                    if(StringUtils.isNotBlank(talkDTO.getToUserId())&&StringUtils.isNotBlank(talkDTO.getContentText())){
                        WebSocketServer socketx=socketMap.get(talkDTO.getToUserId());
                        //需要进行转换，userId
                        if(socketx!=null){
                            talkDTO.setCode(302);
                            socketx.sendMessage(JSON.toJSONString(talkDTO));
                            //此处可以放置相关业务代码，例如存储到数据库
                        }else{
                            WebSocketServer webSocketServer = socketMap.get(userId);
                            webSocketServer.sendMessage(JSON.toJSONString(TalkDTO.error("对方未登录")));
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     *
     * @Author yz
     * @Description 发生错误时调用的方法
     * @Date 2019-10-18 09:58
     * @param session
    * @param error
     * @return void
     */
    @OnError
    public void onError(Session session,Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     *
     * @Author yz
     * @Description 服务器端主动推送
     * @Date 2019-10-18 10:18
     * @param message
     * @return void
     */
    public void sendMessage(String message) throws Exception{
        this.session.getBasicRemote().sendText(message);
    }

    /**
     *
     * @Author yz
     * @Description 群发消息
     * @Date 2019-10-18 10:33
     * @param message
     * @param userId
     * @return void
     */
    public static void sendInfo(String message,@PathParam("userId") String userId) {
        try {
            log.info("推送消息到窗口"+userId +",推送内容"+message);
            Set<Map.Entry<String, WebSocketServer>> entries = socketMap.entrySet();
            for (Map.Entry<String, WebSocketServer> entry : entries) {
                if (entry.getKey().equals(userId)) {
                    entry.getValue().sendMessage(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}
