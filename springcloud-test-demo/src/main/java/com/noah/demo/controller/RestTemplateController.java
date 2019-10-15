package com.noah.demo.controller;

import com.noah.demo.domain.DTO.HttpResponseDTO;
import com.noah.demo.domain.UserDO;
import com.noah.demo.tools.RestTemplateFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName RestTemplateController
 * @Description TODO
 * @Author noah
 * @Date 2019-07-01 17:06
 * @Version 1.0
 **/
@Controller
@RequestMapping("/restTemplate")
public class RestTemplateController {

    @GetMapping("/accessUrl")
    @ResponseBody
    public HttpResponseDTO accessUrl(){
        String responseString = RestTemplateFactory.getRestTemplate()
                .getForObject("Http://www.baidu.com", String.class);
        return HttpResponseDTO.success("请求成功",responseString);
    }

    @GetMapping("/getUser")
    @ResponseBody
    public HttpResponseDTO getUser(Long id){
        if (StringUtils.isEmpty(id)) {
            return HttpResponseDTO.error("请求参数为空");
        }
        UserDO responseDO = RestTemplateFactory.getRestTemplate()
                .getForObject("Http://localhost/user/getUser", UserDO.class, Long.valueOf(id));
        return HttpResponseDTO.success(responseDO);
    }

}
