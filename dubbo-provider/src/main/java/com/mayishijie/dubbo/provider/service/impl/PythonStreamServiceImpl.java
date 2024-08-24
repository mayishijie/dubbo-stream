package com.mayishijie.dubbo.provider.service.impl;

import com.mayishijie.dubbo.provider.service.PythonStreamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author mayishijie
 * @version 1.0  2024/8/23 7:43 PM
 */
@Service
@Slf4j
public class PythonStreamServiceImpl implements PythonStreamService {
    @Override
    public StreamObserver<String> getPythonStream(StreamObserver<String> responseObserver) {
        return new StreamObserver<String>(){
            @Override
            public void onNext(String data) {
                log.info("req===>{}", data);
                WebClient webClient = WebClient.create("http://localhost:5000");
                webClient.get()
                        .uri("/api/stream")
                        .accept(MediaType.TEXT_EVENT_STREAM)
                        .retrieve()
                        .bodyToFlux(String.class)
//                        .map(v->{
//                            log.info("rc======>{}", v);
//                            return v;
//                        })
                        .doOnNext(value->{
                            //todo 处理具体的业务，包装业务逻辑
                            log.info("rc======>{}",value);
                            responseObserver.onNext(value);
                        })
                        .doOnError((e)->{
                            //异常
                            log.error("python服务异常");
                            responseObserver.onError(e);
                        })
                        .doOnComplete(()->{
                            log.info("python全部响应结束");
                            responseObserver.onCompleted();
                        })
                        .subscribe();
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("python onError: " + throwable);
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                //todo 交给webFlux控制结束
                log.info("onCompleted=====1111");
            }
        };
    }
}
