package com.ll.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: cloud2021->FeignConfig
 * @Description: Feign的日志记录
 *                  NONE:默认，不显示任何日志
 *                  BASIC:仅记录请求方法，URL，状态码级执行时间
 *                  HEADERS:除了BASIC的信息外，还有请求和响应头的信息
 *                  FULL:除了HEADERS的信息外，还有请求和响应的正文及元数据
 * @Author: 师建林
 * @Date: 2021-09-30 12:29
 * @Version： 1.0.0
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
