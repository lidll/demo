package com.noah.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author noah
 * @Date 2020-06-11 11:25
 * @Version 1.0
 **/
@RequestMapping("/demo")
@RestController
public class DemoController {

    @GetMapping("/test/{param}")
    public String test(@PathVariable("param")String param){

        Integer integer = Integer.valueOf(param);
        return param;
    }
}
