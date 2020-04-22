package com.snow.springboot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/************
 *  @function com.snow.springboot.config
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:57
 *
 ******/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //负载均衡 才能通过微服务名称调用微服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
