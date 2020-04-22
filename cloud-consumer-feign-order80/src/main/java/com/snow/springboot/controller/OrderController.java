package com.snow.springboot.controller;

import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import com.snow.springboot.service.PaymentFeignService;
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
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Object> create(Payment payment){
        log.info("前端请求，创建订单");
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("前端请求，查询订单");
        return paymentFeignService.getPaymentById(id);
    }

}
