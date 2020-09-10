package com.noah.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @ClassName Person
 * @Description TODO
 * @Author noah
 * @Date 2019-10-14 17:08
 * @Version 1.0
 **/
@Data
@Entity
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    private Integer age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

}
