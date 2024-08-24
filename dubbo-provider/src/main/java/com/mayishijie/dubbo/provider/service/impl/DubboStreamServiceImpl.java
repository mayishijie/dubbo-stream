package com.mayishijie.dubbo.provider.service.impl;

import com.mayishijie.dubbo.facade.DubboStreamService;
import com.mayishijie.dubbo.provider.service.PythonStreamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mayishijie
 * @version 1.0  2024/8/23 7:40 PM
 */
@Slf4j
@Service
@DubboService(protocol = "tri")
public class DubboStreamServiceImpl implements DubboStreamService {
    @Autowired
    private PythonStreamService pythonStreamService;
    @Override
    public StreamObserver<String> streamData(StreamObserver<String> responseObserver) {
        return pythonStreamService.getPythonStream(responseObserver);
    }

    @Override
    public String demo(String name) {
        return "dubbo provider is ok ，req="+name;
    }
}
