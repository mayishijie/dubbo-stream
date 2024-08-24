package com.mayishijie.dubbo.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mayishijie
 * @version 1.0  2024/8/23 7:35 PM
 */
@Slf4j
@EnableDubbo
@SpringBootApplication
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class,args);
        log.info("DubboProviderApplication run sucess");
    }
}
