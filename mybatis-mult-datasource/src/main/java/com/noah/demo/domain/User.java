package com.noah.demo.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName User
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 09:51
 * @Version 1.0
 **/
@Data
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
}
