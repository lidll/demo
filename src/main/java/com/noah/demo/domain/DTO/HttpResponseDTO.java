package com.noah.demo.domain.DTO;

import lombok.Data;

/**
 * @ClassName HttpResponseDTO
 * @Description TODO
 * @Author noah
 * @Date 2019-06-04 15:11
 * @Version 1.0
 **/
@Data
public class HttpResponseDTO {
    private int code = 200;
    private String msg = "success";
    private Object result = "";

    public static HttpResponseDTO success(){
        HttpResponseDTO httpResponseDTO = new HttpResponseDTO();
        httpResponseDTO.setCode(200);
        httpResponseDTO.setMsg("success");
        return httpResponseDTO;
    }

    public static HttpResponseDTO success(String msg){
        HttpResponseDTO httpResponseDTO = new HttpResponseDTO();
        httpResponseDTO.setCode(200);
        httpResponseDTO.setMsg(msg);
        return httpResponseDTO;
    }

    public static HttpResponseDTO success(Object result){
        HttpResponseDTO httpResponseDTO = new HttpResponseDTO();
        httpResponseDTO.setCode(200);
        httpResponseDTO.setMsg("success");
        httpResponseDTO.setResult(result);
        return httpResponseDTO;
    }


    public static HttpResponseDTO success(String msg,Object result){
        HttpResponseDTO httpResponseDTO = new HttpResponseDTO();
        httpResponseDTO.setCode(200);
        httpResponseDTO.setMsg(msg);
        httpResponseDTO.setResult(result);
        return httpResponseDTO;
    }

    public static HttpResponseDTO error(){
        HttpResponseDTO httpResponseDTO = new HttpResponseDTO();
        httpResponseDTO.setCode(500);
        httpResponseDTO.setMsg("fail");
        return httpResponseDTO;
    }

    public static HttpResponseDTO error(String msg){
        HttpResponseDTO httpResponseDTO = new HttpResponseDTO();
        httpResponseDTO.setCode(500);
        httpResponseDTO.setMsg(msg);
        return httpResponseDTO;
    }

}
