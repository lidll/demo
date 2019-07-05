package com.noah.demo;

import com.noah.demo.domain.UserDO;
import com.noah.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        String s = "-1-2-3-4-5-";
        String[] split = s.split("-");
        System.out.println(split[split.length - 1]);
    }

    @Test
    public void createUser(){
        UserDO userDO = new UserDO();
        userDO.setAge(20);
        userDO.setName("张大佬");
        userDO.setCreateDate(new Date());
    }
}
