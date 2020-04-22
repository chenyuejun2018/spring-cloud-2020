package com.snow.springboot.service.impl;

import com.snow.springboot.dao.PaymentDao;
import com.snow.springboot.entities.Payment;
import com.snow.springboot.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/************
 *  @function com.snow.springboot.service.impl
 *  @author chenyuejun
 *  @createDate 2020-03-13 22:14
 *
 ******/

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payMent) {
        return paymentDao.create(payMent);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
