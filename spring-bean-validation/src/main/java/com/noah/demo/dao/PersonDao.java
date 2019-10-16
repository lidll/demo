package com.noah.demo.dao;

import com.noah.demo.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @ClassName PersonDao
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 15:52
 * @Version 1.0
 **/
@Qualifier("dbSqlSessionTemplate")
public interface PersonDao {

    @Insert("insert into person (name,age,create_date,sex)values(" +
            "#{name}," +
            "#{age}," +
            "#{createDate,jdbcType=TIMESTAMP}," +
            "#{sex})")
    void save(Person person);
}
