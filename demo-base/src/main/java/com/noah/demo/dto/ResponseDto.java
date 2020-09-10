package com.noah.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseDto
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 16:57
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
public class ResponseDto<T> {

    private Integer code = 200;
    private T result;
    private String msg;

    public ResponseDto(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseDto(Integer code,String msg,T result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResponseDto(T result){
        this.setMsg("success");
        this.result = result;
    }

    public static ResponseDto success(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        responseDto.setMsg("success");
        return responseDto;
    }

    public static ResponseDto success(String msg){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        responseDto.setMsg(msg);
        return responseDto;
    }

    public static ResponseDto error(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(500);
        responseDto.setMsg("error");
        return responseDto;
    }

    public static ResponseDto error(String msg){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(500);
        responseDto.setMsg(msg);
        return responseDto;
    }
}
