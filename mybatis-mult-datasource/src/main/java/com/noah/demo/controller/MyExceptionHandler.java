package com.noah.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyExceptionHandler
 * @Description TODO
 * @Author noah
 * @Date 2020-06-11 11:31
 * @Version 1.0
 **/
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(Exception e, HttpServletRequest request){
        System.out.println(request.getRequestURL());
        System.out.println(request.getParameterMap());
        e.printStackTrace();
    }
}
