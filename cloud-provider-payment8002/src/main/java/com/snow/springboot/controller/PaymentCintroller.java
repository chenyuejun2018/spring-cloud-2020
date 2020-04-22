package com.snow.springboot.controller;

import com.snow.springboot.entities.CommonResult;
import com.snow.springboot.entities.Payment;
import com.snow.springboot.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> service = discoveryClient.getServices();
        for (String l : service){
            log.info("*****discovery service********"+l);
        }
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance s : list){
            log.info("ServiceInstance HOST:" + s.getHost() +"  PORT:"+s.getPort()+"  URI:"+s.getUri());
        }
        return this.discoveryClient;
    }


}
