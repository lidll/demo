package com.noah.demo.controller;

import com.noah.demo.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName CheckCenterController
 * @Description TODO
 * @Author noah
 * @Date 2019-10-18 10:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("/checkCenter")
public class CheckCenterController {
    //页面请求
    @GetMapping("/socket/{userId}")
    public ModelAndView socket(@PathVariable String userId){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("userId",userId);
        return modelAndView;
    }

    //推送数据接口
    @PostMapping("/socket/push/{userId}")
    public ResponseDto pushToWeb(@PathVariable String userId,@RequestParam("message") String message){
        try {
            WebSocketServer.sendInfo(message, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.error(userId +"===" + e.getMessage());
        }
        return ResponseDto.success(userId);

    }
}
