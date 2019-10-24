package com.noah.demo.dto;

import lombok.Data;

/**
 * @ClassName TalkDTO
 * @Description TODO
 * @Author noah
 * @Date 2019-10-22 09:53
 * @Version 1.0
 **/
@Data
public class TalkDTO {
    /*
     * 发消息用户
     */
    private String fromUserId;
    /*
     * 收消息用户
     */
    private String toUserId;
    /*
     * 发送内容
     */
    private String contentText;
    /*
     * 状态
     */
    private String status;

    private int code;

    public static TalkDTO success(){
        TalkDTO talkDTO = new TalkDTO();
        talkDTO.setStatus("success");
        talkDTO.setCode(200);
        return talkDTO;
    }

    public static TalkDTO error(){
        TalkDTO talkDTO = new TalkDTO();
        talkDTO.setStatus("error");
        talkDTO.setCode(500);
        return talkDTO;
    }
    public static TalkDTO error(String status){
        TalkDTO talkDTO = new TalkDTO();
        talkDTO.setStatus(status);
        talkDTO.setCode(500);
        return talkDTO;
    }

    public static TalkDTO talk(String fromUserId,String toUserId,String contentText){
        TalkDTO talkDTO = new TalkDTO();
        talkDTO.setFromUserId(fromUserId);
        talkDTO.setToUserId(toUserId);
        talkDTO.setContentText(contentText);
        talkDTO.setCode(302);
        return talkDTO;
    }
}
