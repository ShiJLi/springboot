package com.ll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Program: cloud2021->EurekaMain7001
 * @Description: Eureka 注册中心 服务启动类
 * @Author: Administrator
 * @Date: 2021-09-21 08:51
 * @Version： 1.0.0
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
