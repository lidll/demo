package com.noah.demo.db1.dao;

import com.noah.demo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:26
 * @Version 1.0
 **/
@Qualifier("db1SqlSessionTemplate")
public interface UserDao {

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);
}
