package com.snow.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/************
 *  @function com.snow.springboot.controller
 *  @author chenyuejun
 *  @createDate 2020-03-21 20:22
 *
 ******/
@RestController
@EnableBinding(Sink.class) /**消费者标记*/
@Slf4j
public class ReceiverMsgController {

    @Value("${server.port}")
    private String port;

    /** 监听接收消息注解 */
    @StreamListener(Sink.INPUT)
    public void receiverMsg(Message<String> msg){
        log.info("接收到消息："+ msg.getHeaders().toString()+ " 内容： "+ msg.getPayload() + "端口：" + port);
    }

}
