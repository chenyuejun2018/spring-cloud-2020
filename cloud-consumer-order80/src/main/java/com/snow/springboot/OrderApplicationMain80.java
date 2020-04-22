package com.snow.springboot;

import com.snow.config.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:47
 *
 ******/
@SpringBootApplication
@EnableEurekaClient
/** 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效 **/
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRuleConfig.class)
public class OrderApplicationMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationMain80.class,args);
    }
}
