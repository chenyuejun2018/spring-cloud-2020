package com.snow.springboot.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/************
 *  @function
 *      以代码的方式配置路由规则
 *  @author chenyuejun
 *  @createDate 2020-03-18 12:37
 *
 ******/
@Configuration
public class GatewayConfig {

    /**
     *  配置一个路由id为path_route_snow的路由规则
     *  当访问http://localhost:9527/payment/create时，会转发到 http://localhost:8008/payment/create
     *  请求地址：http://localhost:9527/payment/create?serial=pig001
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_snow",r -> r.path("/payment/create").uri("http://localhost:8008/payment/create")).build();

        return routes.build();
    }
}
