package com.noah.demo.service.impl;

import com.noah.demo.dao.UserDao;
import com.noah.demo.domain.UserDO;
import com.noah.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author noah
 * @Date 2019-06-03 18:02
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDO getUser(Long id) {
        return userDao.getById(id);
    }

    @Override
    public int save(UserDO userDO) {
        return userDao.save(userDO);
    }
}
