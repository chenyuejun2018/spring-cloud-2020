package com.snow.springboot.controller;

import com.snow.springboot.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/************
 *  @function com.snow.springboot.controller
 *  @author chenyuejun
 *  @createDate 2020-03-21 17:11
 *
 ******/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider msgProvider;

    @GetMapping("/provider/rabbit/send")
    public String sendMsg(){
        return msgProvider.send();
    }
}
