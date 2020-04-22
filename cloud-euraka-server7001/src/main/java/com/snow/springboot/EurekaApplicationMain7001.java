package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-14 15:03
 *
 ******/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationMain7001.class,args);
    }

}
