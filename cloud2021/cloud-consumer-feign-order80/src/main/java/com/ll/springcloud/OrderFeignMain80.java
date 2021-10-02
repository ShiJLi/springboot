package com.ll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Program: cloud2021->OrderFeignMain80
 * @Description: openfeign 调用
 * @Author: 师建林
 * @Date: 2021-09-29 19:05
 * @Version： 1.0.0
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
