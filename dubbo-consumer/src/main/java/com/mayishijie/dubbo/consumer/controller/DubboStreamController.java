package com.mayishijie.dubbo.consumer.controller;

import com.mayishijie.dubbo.consumer.service.DubboBusiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author mayishijie
 * @version 1.0  2024/8/23 8:04 PM
 */
@Slf4j
@RestController
@RequestMapping
public class DubboStreamController {
    @Autowired
    private DubboBusiService dubboBusiService;

    @GetMapping("/ok")
    public String test1() {
       return dubboBusiService.demo("OK");
    }


    @GetMapping(value = "/stream", produces = "text/event-stream")
    public Flux<String> test2() {
        return dubboBusiService.stremDate("stream");
    }
}
