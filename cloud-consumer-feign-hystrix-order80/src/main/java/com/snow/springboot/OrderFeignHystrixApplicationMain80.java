package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:47
 *
 ******/
@SpringBootApplication
/** 激活openfeign ***/
@EnableFeignClients
/** 客户端 激活Hystrix服务保护功能 */
@EnableHystrix
public class OrderFeignHystrixApplicationMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplicationMain80.class,args);
    }
}
