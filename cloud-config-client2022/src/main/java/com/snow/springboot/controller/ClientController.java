package com.snow.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/************
 *  @function com.snow.springboot.controller
 *  @author chenyuejun
 *  @createDate 2020-03-19 2:12
 *
 ******/
@RestController

/** 动态加载配置中心参数
 *  客户端配置修改完成后，如果Github上文件改动了需要另外发一次请求通知2021客户端服务，
 *  发送POST请求： curl -X POST "http://localhost:2022/actuator/refresh"
 * */
@RefreshScope
public class ClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/client/info")
    public String getConfigInfo() {
        return info;
    }
}
