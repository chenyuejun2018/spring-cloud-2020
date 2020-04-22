package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:47
 *
 * value, basePackages (默认{})
 * basePackageClasses (默认{})
 * defaultConfiguration (默认{})
 * clients (默认{})
 *
 ******/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignApplicationMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplicationMain80.class,args);
    }
}
