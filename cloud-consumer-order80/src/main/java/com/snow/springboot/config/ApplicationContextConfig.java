package com.snow.springboot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/************
 *  @function com.snow.springboot.config
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:57
 *
 ******/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //负载均衡 才能通过微服务名称调用微服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**在此处配置选择Ribbon自带的其他策略，默认是轮询策略******/
    /**一下是几种策略的说明：
     * RandomRule   随机策略--随机选择server
     * RoundRobinRule  轮询策略--按顺序循环选择server
     * RetryRule    重试策略--在一个配置时间段内，当选择server不成功，则一直尝试选择一个可用的server
     * WeightedResponseTimeRule  响应时间加权策略--根据server的响应时间分配权重，响应时间越长权重越低
     *                  被选择的概率就越低；响应时间越短，权重越高，被选择的概率就越高；
     *                  这个策略很贴切，综合了各种因素，如网络，磁盘，IO等这些因素直接影响响应时间
     * BestAvailableRule  最低并发策略--逐个考察server，当server断路器打开则忽略，
     *                      再选择其中并发连接最低的server
     * AvailabilityFilteringRule  可用过滤策略--过滤掉一直连接失败，并且被标记为circuit tripped的server
     *                             （activity connections 超过配置的网值）
     * ZoneAvoidanceRule  区域权衡策略--综合判断server所在区域的性能和server的可用性轮询选择server
     *                      并判断一个AWS zone的运行性能是否可用，剔除不可用的Zone中的所有server
     * 一般不用的策略：
     * ClientConfigEnabledRoundRobinRule 该策略较为特殊，我们一般不直接使用它，因为它本身并没有实现什么
     *                                   特殊的处理逻辑，正如下面的源码所示，在它的内部定义了一个RoundRobinRule策略，
     *                                   而choose函数的实现也正是使用了RoundRobinRule的线性轮询机制，所以它
     *                                   实现的功能实际上与RoundRobinRule相同
     * PredicateBasedRule  基于Predicate实现的策略--继承了ClientConfigEnabledRoundRobinRule
     * */
    /**@Bean
    public IRule myRule(){
        //return new RoundRobinRule();
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
        return new RetryRule();  //在这里选择负载均衡算法
    }*/

}
