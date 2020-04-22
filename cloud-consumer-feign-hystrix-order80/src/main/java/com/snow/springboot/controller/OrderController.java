package com.snow.springboot.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import com.snow.springboot.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/************
 *  @function com.snow.springboot.controller
 *          Eureka + OpenFeign（自带集成Ribbon） 服务调用实现负载均衡功能
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:53
 *
 ******/

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Object> create(Payment payment){
        log.info("前端请求，创建订单");
        return paymentFeignHystrixService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("前端请求，查询订单");
        return paymentFeignHystrixService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/paymentOk/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        int n = 10/0;
        return paymentFeignHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/paymentTimeout/{id}")
    /** 服务降级控制，出现超时或者异常，进入指定方法进行处理
     *
     * @HystrixCommand 指定了方法，调找指定的方法
     * @HystrixCommand 没有指定方法，默认调类上@DefaultProperties指定的全局方法
     * */
    @HystrixCommand( fallbackMethod = "paymentFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    //@HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id){
        return paymentFeignHystrixService.paymentTimeout(id);
    }

    /**
     *   超时异常，运行异常回调方法
     * @param id
     * @return
     */
    public String paymentFallback(Integer id){
        return "客户端服务复杂业务逻辑ID: "+ id + "请稍等。。。。 线程：" + Thread.currentThread().getName();
    }

    /**
     *  类上面注解@DefaultProperties指定的全局方法
     * **/
    public String globalFallback(){
        return "GLOBAL 出错了，出错了。。。。 线程：" + Thread.currentThread().getName();
    }
}
