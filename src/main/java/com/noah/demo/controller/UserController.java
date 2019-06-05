package com.noah.demo.controller;

import com.noah.demo.domain.DTO.HttpResponseDTO;
import com.noah.demo.domain.UserDO;
import com.noah.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author noah
 * @Date 2019-06-03 16:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long")
    @GetMapping("/getUser")
    @ResponseBody
    public HttpResponseDTO getUser(@RequestParam Long id){
        UserDO userDO = userService.getUser(id);
        return HttpResponseDTO.success(userDO);
    }

    @ApiOperation(value = "保存用户信息",notes = "保存用户信息")
    @PostMapping("/save")
    @ResponseBody
    public HttpResponseDTO save(@RequestBody UserDO userDO){
        int save = userService.save(userDO);
        if (save >= 0) {
            return HttpResponseDTO.success();
        }else {
            return HttpResponseDTO.error();
        }
    }
}
