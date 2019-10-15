package com.noah.demo.db2.dao;

import com.noah.demo.domain.Salary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SalaryDao
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:26
 * @Version 1.0
 **/
@Qualifier("db2SqlSessionTemplate")
@Repository
public interface SalaryDao {

    @Select("select * from salary where user_id = #{value}")
    Salary findSalaryByUserId(Long userId);
}
