package com.ll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Program: cloud2021->OrderHystrixMain80
 * @Description: Hystrix服务降级，消费端
 * @Author: 师建林
 * @Date: 2021-09-30 17:13
 * @Version： 1.0.0
 **/
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
