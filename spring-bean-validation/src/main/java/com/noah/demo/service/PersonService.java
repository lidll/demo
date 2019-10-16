package com.noah.demo.service;

import com.noah.demo.dao.PersonDao;
import com.noah.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PersonService
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 16:00
 * @Version 1.0
 **/
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void save(Person person){
        personDao.save(person);
    }
}
