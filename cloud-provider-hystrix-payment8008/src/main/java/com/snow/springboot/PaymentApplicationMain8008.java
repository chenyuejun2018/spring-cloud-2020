package com.snow.springboot;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/************
 *  @function com.snow.springboot
 *  @author chenyuejun
 *  @createDate 2020-03-14 17:44
 *   使用JMeter压力测试，请求有复杂有延时的的接口，导致其他服务接口响应慢
 ******/

@SpringBootApplication
@EnableEurekaClient    // Eureka
@EnableDiscoveryClient //服务发现
/** 服务端 激活Hystrix服务降级功能 */
@EnableCircuitBreaker
public class PaymentApplicationMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationMain8008.class);
    }

    /**
     *  为了Hystrix服务监控而配置，与服务容错本身无关，
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return  registrationBean;
    }
}
