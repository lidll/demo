package com.noah.chat.webscoket_server;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @ClassName SocketServer
 * @Description TODO
 * @Author noah
 * @Date 2019-10-31 11:42
 * @Version 1.0
 **/
@ServerEndpoint("/chat")
@Component
public class SocketServer {

    private Session session;

    @OnOpen
    public void onOpen(Session session){}

    @OnMessage
    public void onMessage(Session session,String message){}

    @OnError
    public void onError(Session session,Throwable error){}

    @OnClose
    public void onClose(){}


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

}
