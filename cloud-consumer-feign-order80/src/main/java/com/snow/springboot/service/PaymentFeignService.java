package com.snow.springboot.service;

import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/************
 *  @function com.snow.springboot.service
 *      接口注解@FeignClient( value = "CLOUD-PAYMENT-SERVICE")
 *      接口方法与服务提供者对应
 *  @author chenyuejun
 *  @createDate 2020-03-16 16:00
 *
 * @FeignClient标注的参数
 * name, value (默认"")，两者等价
 * qualifier (默认"")
 * url (默认"")
 * decode404 (默认false)
 * configuration (默认FeignClientsConfiguration.class)
 * fallback (默认void.class)
 * fallbackFactory (默认void.class)
 * path (默认"")
 * primary (默认true)
 *
 ******/
@Component
@FeignClient( value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/create")
    public CommonResult<Object> create(Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

}
