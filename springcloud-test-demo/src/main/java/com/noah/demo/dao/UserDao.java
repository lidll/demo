package com.noah.demo.dao;

import com.noah.demo.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author noah
 * @Date 2019-06-03 16:09
 * @Version 1.0
 **/
@Mapper
public interface UserDao {
    UserDO getById(Long id);

    int save(UserDO userDO);
}
