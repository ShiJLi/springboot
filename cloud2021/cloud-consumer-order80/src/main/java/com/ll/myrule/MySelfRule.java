package com.ll.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: cloud2021->MySelfRule
 * @Description: 自定义负载均衡规则
 * @Author: Administrator
 * @Date: 2021-09-21 17:14
 * @Version： 1.0.0
 **/
@Configuration
public class MySelfRule {


    @Bean
    public IRule myRule(){
        //随机规则
        return new RandomRule();
    }
}
