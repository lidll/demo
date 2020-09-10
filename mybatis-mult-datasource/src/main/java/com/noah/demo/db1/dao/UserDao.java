package com.noah.demo.db1.dao;

import com.noah.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:26
 * @Version 1.0
 **/
@Mapper
public interface UserDao {

    User findByName(String name);
}
