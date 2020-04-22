package com.snow.springboot.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/************
 *  @function com.snow.springboot.conf
 *     feign 日志配置
 *  @author chenyuejun
 *  @createDate 2020-03-16 17:14
 *
 ******/
@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
