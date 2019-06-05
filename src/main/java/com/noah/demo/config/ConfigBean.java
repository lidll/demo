package com.noah.demo.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName configBean
 * @Description TODO
 * @Author noah
 * @Date 2019-05-30 16:50
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "my")
@Component
@Data
@ToString
public class ConfigBean {
    String name;
    int age;
    int salary;
}
