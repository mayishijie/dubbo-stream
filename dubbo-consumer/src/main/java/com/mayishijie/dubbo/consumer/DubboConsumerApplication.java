package com.mayishijie.dubbo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mayishijie
 * @version 1.0  2024/8/23 5:51 PM
 */
@Slf4j
@SpringBootApplication
@EnableDubbo
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class,args);
        log.info("DubboConsumerApplication run success");
    }
}
