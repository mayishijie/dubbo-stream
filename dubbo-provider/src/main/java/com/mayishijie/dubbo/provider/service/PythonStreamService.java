package com.mayishijie.dubbo.provider.service;

import org.apache.dubbo.common.stream.StreamObserver;

public interface PythonStreamService {
    /**
     *
      * @param responseObserver 响应流
     * @return 输入流
     */
    StreamObserver<String> getPythonStream(StreamObserver<String> responseObserver);

}
