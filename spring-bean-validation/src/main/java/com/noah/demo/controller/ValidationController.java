package com.noah.demo.controller;

import com.noah.demo.domain.Person;
import com.noah.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName ValidationController
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 16:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
public class ValidationController {

    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public String savePerson(@RequestBody @Valid Person person){
        personService.save(
                person
        );
        return "ok";
    }
}
