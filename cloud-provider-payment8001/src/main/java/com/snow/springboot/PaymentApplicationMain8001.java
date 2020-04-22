package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-13 21:24
 *
 ******/

@SpringBootApplication
@EnableEurekaClient    // Eureka
@EnableDiscoveryClient //服务发现
public class PaymentApplicationMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationMain8001.class);
    }
}
