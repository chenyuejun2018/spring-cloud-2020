package com.snow.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/************
 *  @function 自定义Gateway过滤器
 *  @author chenyuejun
 *  @createDate 2020-03-18 14:28
 *
 ******/
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter,Ordered {

    /**
     * 测试URL ：http://localhost:9527/payment/get/106?name=111
     * name不为空才能通过
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //过滤逻辑
        log.info("自定义过滤器。。。。。。。。。。");
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (name == null) {
            /*log.info("name 为空。。。。。。");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();*/
        }
        return chain.filter(exchange);
    }

    /**
     *  加载过滤器的顺序，数字越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
