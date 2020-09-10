package com.noah.demo.controller;

import com.noah.demo.config.WS;
import com.noah.demo.dto.ResponseDto;
import com.noah.demo.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class LoginController {

    @GetMapping("/")
    String login() {
        return "login.html";
    }

    @GetMapping("/login")
    String loginPage() {
        return "login.html";
    }

    /**
     * @param username
     * @return java.lang.String
     * @Author yz
     * @Description 用户登录
     * @Date 2019-10-25 11:25
     */
    @PostMapping("/checkUser")
    @ResponseBody
    public ResponseDto login(@RequestParam("username") String username) {
        Subject subject = SecurityUtils.getSubject();
        //在认证提交前准备Token令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, "aaa");
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return ResponseDto.error("未知账户");
        } catch (IncorrectCredentialsException ice) {
            return ResponseDto.error("密码不正确");
        } catch (LockedAccountException lae) {
            return ResponseDto.error("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return ResponseDto.error("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return ResponseDto.error("当前用户名已存在聊天室！");
        }
        if (subject.isAuthenticated()) {
            return ResponseDto.success("登录成功");
        } else {
            token.clear();
            return ResponseDto.error("登录失败");
        }
    }

    /**
     * @param model
     * @return java.lang.String
     * @Author yz
     * @Description 登录
     * @Date 2019-10-25 14:02
     */
    @GetMapping("/goTalk")
    public String index(Model model) {
        //当前用户
        Subject subjct = ShiroUtils.getSubjct();
        String username = subjct.getPrincipal().toString();
        model.addAttribute("userId", username);
        //在线用户
        ConcurrentHashMap<String, WebSocketServer> socketMap = WS.socketMap;
        List<String> usernameList = new ArrayList<>();
        for (Map.Entry<String, WebSocketServer> entry : socketMap.entrySet()) {
            usernameList.add(entry.getKey());
        }
        model.addAttribute("usernameList",usernameList);
        return "talk";
    }

    /**
     * @param
     * @return java.lang.String
     * @Author yz
     * @Description 登出
     * @Date 2019-10-25 11:26
     */
    @GetMapping("/logout")
    String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

}
