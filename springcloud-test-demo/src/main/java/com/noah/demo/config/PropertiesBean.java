package com.noah.demo.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName PropertiesBean
 * @Description TODO
 * @Author noah
 * @Date 2019-05-30 17:08
 * @Version 1.0
 **/
//启动注入参数
@Configuration
@ConfigurationProperties(prefix = "com.noah")
@PropertySource("src/main/resources/test.properties")
@Data
@ToString
public class PropertiesBean {
    private String name;
    private String age;
}
