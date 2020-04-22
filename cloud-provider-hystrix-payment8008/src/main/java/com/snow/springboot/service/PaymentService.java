package com.snow.springboot.service;

import com.snow.springboot.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/************
 *  @function com.snow.springboot.service
 *  @author chenyuejun
 *  @createDate 2020-03-13 22:13
 *
 ******/
public interface PaymentService {

    public int create(Payment payMent);

    public Payment getPaymentById(Long id);

    public String paymentOk(Integer id);

    public String paymentTimeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
