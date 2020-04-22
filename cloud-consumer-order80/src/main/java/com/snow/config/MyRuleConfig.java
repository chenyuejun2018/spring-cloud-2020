package com.snow.config;

import com.netflix.loadbalancer.IRule;
import com.snow.customize.CustomizeBalancerRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/************
 *  @function Ribbon的自定义负载均衡算法
 *      1.在springboot主程序扫描的包外定义配置类，
 *      2.然后为springboot主程序添加 @RibbonClient 注解引入配置类
 *  @author chenyuejun
 *  @createDate 2020-03-16 0:15
 *
 ******/
@Configuration
public class MyRuleConfig {

    /**将自定的负载均衡策略加入到spring容器中*/
    @Bean
    public IRule myRule(){
        return new CustomizeBalancerRule();
    }
}
