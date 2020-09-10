package com.noah.demo.service;

import com.noah.demo.dao.PeopleDao;
import com.noah.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author noah
 * @Date 2020-05-03 23:13
 * @Version 1.0
 **/
@Service
public class PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public User getUserByName(String name){
       return peopleDao.findByName(name);
    }
}
