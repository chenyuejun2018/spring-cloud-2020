package com.snow.springboot.controller;

import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import com.snow.springboot.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/************
 *  @function com.snow.springboot.controller
 *  @author chenyuejun
 *  @createDate 2020-03-13 22:16
 *
 ******/
@RestController
@Slf4j
public class PaymentCintroller {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping( value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("插入结果："+serverPort+ result);
        if (result > 0){
            return new CommonResult(200,"插入成功"+serverPort,result);
        } else {
            return new CommonResult(400,"插入失败"+serverPort, null );
        }

    }

    @GetMapping( value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment result = paymentService.getPaymentById(id);
        log.info( "查询结果："+serverPort+ result);
        return new CommonResult(200,"查询成功"+serverPort,result);
    }

    /**
     *  模拟简单没有延时的业务逻辑
     * @param id
     * @return
     */
    @GetMapping("/payment/paymentOk/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentOk(id);
        log.info(result);
        return result;
    }

    /**
     *  模拟复杂耗时长的业务逻辑
     * @param id
     * @return
     */
    @GetMapping("/payment/paymentTimeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentTimeout(id);
        log.info(result);
        return result;
    }

    /**
     *  熔断测试方法
     *  http://localhost:8008/payment/paymentCircuitBreaker/1
     * @param id
     * @return
     */
    @GetMapping("/payment/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info(result);
        return result;
    }

}
