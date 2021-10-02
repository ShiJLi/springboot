package com.ll.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Program: cloud2021->LoadBalancer
 * @Description: 负载均衡算法接口
 * @Author: Administrator
 * @Date: 2021-09-21 18:06
 * @Version： 1.0.0
 **/
public interface LoadBalancer {

    ServiceInstance instances (List<ServiceInstance> serviceInstances);
}
