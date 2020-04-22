package com.snow.springboot.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.snow.springboot.dao.PaymentDao;
import com.snow.springboot.entities.Payment;
import com.snow.springboot.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @Override
    public String paymentOk(Integer id){
        return "简单业务逻辑  paymentOk ID:  "+ id + " 线程：" + Thread.currentThread().getName();
    }

    /**
     *   服务降级控制，出现超时或者异常，进入指定方法进行处理
     * @param id
     * @return
     */
    @HystrixCommand( fallbackMethod = "paymentFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String paymentTimeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {

        }
        return "复杂业务逻辑  paymentTimeout 4s ID: "+ id + " 线程：" + Thread.currentThread().getName();
    }

    /**
     *   超时异常，运行异常回调方法
     * @param id
     * @return
     */
    public String paymentFallback(Integer id){
        return "复杂业务逻辑ID: "+ id + "请稍等。。。。 线程：" + Thread.currentThread().getName();
    }

    /************************************************************************/
    /***服务熔断***/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled" , value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "10000"),//时间窗口期，时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "20")//失败概率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+ "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id 不能为负数，请重试   ID :" + id;
    }
}
