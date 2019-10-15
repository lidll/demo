package com.noah.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserDO
 * @Description TODO
 * @Author noah
 * @Date 2019-06-03 16:07
 * @Version 1.0
 **/
@Data
public class UserDO implements Serializable {
    private Long id;
    private String name;
    private int age;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
}
