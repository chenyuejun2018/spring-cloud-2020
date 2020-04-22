package com.snow.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.snow.springboot.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/************
 *  @function com.snow.springboot.service.impl
 *  @author chenyuejun
 *  @createDate 2020-03-21 16:50
 *
 ******/
/**生产者的发送管道Exchange*/
/**这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，
 * 可以看到output和input,这和配置文件中的output，input对应的。*/
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send(){

        String serial = UUID.fastUUID().toString();
        String now = DateUtil.now();
        output.send(MessageBuilder.withPayload(now + "---" + serial)
                .setHeader("ProviderSend","UUID")
                .build());
        log.info(now + "---" + serial);
        return now + "---" + serial;
    }

}
