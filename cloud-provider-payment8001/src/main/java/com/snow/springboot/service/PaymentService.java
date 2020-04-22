package com.snow.springboot.service;

import com.snow.springboot.entities.Payment;
import org.apache.ibatis.annotations.Param;

/************
 *  @function com.snow.springboot.service
 *  @author chenyuejun
 *  @createDate 2020-03-13 22:13
 *
 ******/
public interface PaymentService {

    public int create(Payment payMent);

    public Payment getPaymentById(@Param("id")Long id);
}
