package com.noah.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author noah
 * @Date 2019-10-18 10:53
 * @Version 1.0
 **/
@Controller
//使用RestController会导致跳转html失败,而只显示index,因为该注解中包含@ResponseBody,会将返回信息转换成json
//@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "talk";
    }

}
