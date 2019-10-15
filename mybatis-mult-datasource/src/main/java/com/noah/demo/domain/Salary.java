package com.noah.demo.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Salary
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 09:52
 * @Version 1.0
 **/
@Data
@ToString
public class Salary {
    private Long id;
    private Double salary;
    private int level;
    private String name;
    private Long userId;
}
