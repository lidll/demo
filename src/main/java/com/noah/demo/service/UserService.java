package com.noah.demo.service;

import com.noah.demo.domain.UserDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author noah
 * @Date 2019-06-03 18:01
 * @Version 1.0
 **/
public interface UserService {
    UserDO getUser(@RequestParam Long id);

    int save(@RequestBody UserDO userDO);
}
