package com.noah.demo.exception;

import com.noah.demo.controller.ValidationController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理类
 * @Author noah
 * @Date 2019-10-15 16:50
 * @Version 1.0
 **/
@ControllerAdvice(assignableTypes = {ValidationController.class})
@ResponseBody
public class GlobalExceptionHandler {

    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误"));
    ErrorResponse resourceNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("Sorry, the resourse not found!"));
    ErrorResponse exceptionResponse = new ErrorResponse(new Exception("错啦错啦错啦"));
    /*
     *
     * @Author yz
     * @Description 拦截所有异常
     * @Date 2019-10-15 16:54
     * @param e
     * @return org.springframework.http.ResponseEntity<com.noah.demo.exception.ErrorResponse>
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        if (e instanceof  IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        }else if (e instanceof ResourceNotFoundException){
            return ResponseEntity.status(404).body(resourceNotFoundResponse);
        }else{
            return ResponseEntity.status(401).body(exceptionResponse);
        }
    }
}
