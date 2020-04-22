package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-18 19:14
 *
 ******/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterApplicationMain2020 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplicationMain2020.class,args);
    }
}
