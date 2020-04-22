package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-15 1:56
 *
 ******/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplicationMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationMain8006.class,args);
    }
}
