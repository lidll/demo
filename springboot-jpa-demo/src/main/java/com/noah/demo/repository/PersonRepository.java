package com.noah.demo.repository;

import com.noah.demo.base.JpaRepository;
import com.noah.demo.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @ClassName PersonRepository
 * @Description TODO
 * @Author noah
 * @Date 2019-10-14 17:15
 * @Version 1.0
 **/
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByName(String name);

    /**
     *
     * @Author yz
     * @Description 查找比条件小的年龄的人
     * @Date 2019-10-14 17:23
     * @param age
     * @return java.util.List<com.noah.demo.entity.Person>
     */
    List<Person> findByAgeLessThan(Integer age);

    /**
     *
     * @Author yz
     * @Description sql查询 年龄比条件大的人
     * @Date 2019-10-14 17:26
     * @param age
     * @return java.util.List<com.noah.demo.entity.Person>
     */
    @Query("select p from Person p where age > :age")
    List<Person> findByAgeGreaterThan(@Param("age") Integer age);


    /**
     *
     * @Author yz
     * @Description sql占位符顺序使用参数列表参数
     * @Date 2019-10-14 17:58
     * @param id
     * @param name
     * @param age
     * @return void
     */
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("update Person p set p.name = ?2 ,p.age = ?3 where p.id = ?1")
    void updateNameAndAgeById(Long id,String name,Integer age);


    @Async
    Future<Person> findByAge(Integer id);


}
