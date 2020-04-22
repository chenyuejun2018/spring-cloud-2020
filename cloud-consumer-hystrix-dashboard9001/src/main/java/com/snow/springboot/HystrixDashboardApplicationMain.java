package com.snow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import sun.applet.Main;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-17 19:43
 *
 ******/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplicationMain.class,args);
    }
}
