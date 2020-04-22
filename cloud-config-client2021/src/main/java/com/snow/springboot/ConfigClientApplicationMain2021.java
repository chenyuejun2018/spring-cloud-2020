package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-19 2:10
 *
 ******/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplicationMain2021 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplicationMain2021.class,args);
    }
}
