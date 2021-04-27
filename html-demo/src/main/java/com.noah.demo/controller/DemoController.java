package com.noah.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author noah
 * @Date 3/31/21 11:04 AM
 * @Version 1.0
 **/
@Controller
public class DemoController {

    @GetMapping("/index")
    public String index(Model model){
        return "demo";
    }
}
