package com.ll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: Shijl
 * @Date: 2021-10-02 09:55
 * @Version： 1.0.0
 **/
@SpringBootApplication
@EnableHystrixDashboard  //Hystrix监控
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class);
    }
}
