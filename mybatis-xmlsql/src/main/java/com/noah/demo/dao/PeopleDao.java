package com.noah.demo.dao;

import com.noah.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName PeopleDao
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:26
 * @Version 1.0
 **/
@Mapper
public interface PeopleDao {

    User findByName(String name);
}
