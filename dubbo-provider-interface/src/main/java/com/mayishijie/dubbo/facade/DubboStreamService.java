package com.mayishijie.dubbo.facade;

import org.apache.dubbo.common.stream.StreamObserver;

public interface DubboStreamService {
    StreamObserver<String> streamData(StreamObserver<String> responseObserver);

    String demo(String name);

}
