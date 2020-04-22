package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-15 14:33
 *
 ******/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplicationMainZk80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationMainZk80.class,args);
    }
}
