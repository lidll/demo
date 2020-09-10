package com.noah.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ChatApplication
 * @Description TODO
 * @Author noah
 * @Date 2019-10-31 11:39
 * @Version 1.0
 **/
@SpringBootApplication
@Slf4j
public class ChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class);
        log.info("ChatApplication启动了");
    }
}
