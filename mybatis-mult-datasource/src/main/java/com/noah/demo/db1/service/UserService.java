package com.noah.demo.db1.service;

import com.noah.demo.db1.dao.UserDao;
import com.noah.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:31
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserByName(String name){
        return userDao.findByName(name);
    }
}
