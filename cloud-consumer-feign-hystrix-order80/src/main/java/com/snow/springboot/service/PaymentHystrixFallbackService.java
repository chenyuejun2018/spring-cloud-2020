package com.snow.springboot.service;

import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import org.springframework.stereotype.Component;

/************
 *  @function 针对某个服务下所有接口进行服务降级处理
 *  @author chenyuejun
 *  @createDate 2020-03-17 16:37
 *
 ******/

@Component
public class PaymentHystrixFallbackService implements PaymentFeignHystrixService {


    @Override
    public CommonResult<Object> create(Payment payment) {
        return new CommonResult<>(500,"PaymentHystrixFallbackService服务出错啦");
    }

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(500,"PaymentHystrixFallbackService服务出错啦");
    }

    @Override
    public String paymentOk(Integer id) {
        return "500  PaymentHystrixFallbackService服务出错啦";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "500  PaymentHystrixFallbackService服务出错啦";
    }
}
