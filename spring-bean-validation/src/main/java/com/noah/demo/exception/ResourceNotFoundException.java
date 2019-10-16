package com.noah.demo.exception;

import lombok.Data;

/**
 * @ClassName ResourceNotFoundException
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 16:30
 * @Version 1.0
 **/
@Data
public class ResourceNotFoundException extends RuntimeException{

    private String message;

    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
