package com.noah.demo.exception;

import lombok.Data;

/**
 * @ClassName ErrorResponse
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 16:27
 * @Version 1.0
 **/
@Data
public class ErrorResponse {

    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e){
        this(e.getClass().getName(),e.getMessage());
    }

    public ErrorResponse(String errorTypeName,String message){
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
