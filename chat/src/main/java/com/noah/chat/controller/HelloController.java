package com.noah.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author noah
 * @Date 2019-10-31 17:49
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "/index";
    }
}
