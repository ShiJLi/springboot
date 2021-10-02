package com.ll.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Program: cloud2021->ApplicationContextConfig
 * @Description: 配置类
 * @Author: Administrator
 * @Date: 2021-09-20 17:38
 * @Version： 1.0.0
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
