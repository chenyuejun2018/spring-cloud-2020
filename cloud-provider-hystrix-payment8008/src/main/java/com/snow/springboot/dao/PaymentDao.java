package com.snow.springboot.dao;

import com.snow.springboot.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/************
 *  @function com.snow.springboot.dao
 *  @author chenyuejun
 *  @createDate 2020-03-13 21:55
 *
 ******/
@Mapper
public interface PaymentDao {

    public int create(Payment payMent);

    public Payment getPaymentById(@Param("id")Long id);

}
