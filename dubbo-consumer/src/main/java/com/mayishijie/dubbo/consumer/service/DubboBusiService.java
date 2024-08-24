package com.mayishijie.dubbo.consumer.service;

import com.mayishijie.dubbo.facade.DubboStreamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author mayishijie
 * @version 1.0  2024/8/23 7:58 PM
 */
@Slf4j
@Service
public class DubboBusiService {
    @DubboReference(protocol = "tri")
    private DubboStreamService dubboStreamService;


    public String demo(String name)
    {
        return dubboStreamService.demo(name);
    }

    public Flux<String> stremDate(String req){
        return Flux.create(sink->{
            StreamObserver<String> responseObserver = dubboStreamService.streamData( new StreamObserver<String>() {
                @Override
                public void onNext(String data) {
                    log.info("resp======>{}",data);
                    sink.next(data);
                }

                @Override
                public void onError(Throwable throwable) {
                    log.error("resp error====>" , throwable);
                    sink.error(throwable);
                }

                @Override
                public void onCompleted() {
                    log.info("resp onCompleted=====>22222");
                    sink.complete();
                }


            });
            sink.onCancel(()->{
                log.info("取消");
                responseObserver.onCompleted();
            });
            // 发送一次请求参数给服务 B
            responseObserver.onNext("我是一个flux参数");
            responseObserver.onCompleted();
        });
    }
}
