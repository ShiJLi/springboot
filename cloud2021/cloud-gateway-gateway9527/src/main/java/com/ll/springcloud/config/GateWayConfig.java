package com.ll.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: GateWay 编码配置路由
 * @Author: 师建林
 * @Date: 2021-10-02 14:21
 * @Version： 1.0.0
 **/
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route_ll",r -> r.path("/guonei")
                        .uri("http://news.baidu.com"))
                .build();
    }

}
