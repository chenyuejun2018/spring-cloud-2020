package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-17 1:59
 *
 ******/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationMain7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationMain7003.class,args);
    }
}
