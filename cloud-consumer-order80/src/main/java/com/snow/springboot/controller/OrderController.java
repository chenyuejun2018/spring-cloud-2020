package com.snow.springboot.controller;

import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/************
 *  @function com.snow.springboot.controller
 *          Eureka + Ribbon + RestTemplate 实现负载均衡
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:53
 *
 ******/

@RestController
@Slf4j
public class OrderController {

    //单机配置写死
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //集群配置需要写微服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("前端请求，创建订单");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("前端请求，查询订单 getForObject ");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment0/get/{id}")
    public CommonResult<Payment> getPayment0(@PathVariable("id") Long id){
        log.info("前端请求，查询订单 getForEntity");
        ResponseEntity<CommonResult> re = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(re.getStatusCode().is2xxSuccessful()){
            return re.getBody();
        } else {
            return new CommonResult<>(400,"数据为空");
        }
    }

}
