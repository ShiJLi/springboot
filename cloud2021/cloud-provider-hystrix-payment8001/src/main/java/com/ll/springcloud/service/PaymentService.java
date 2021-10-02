package com.ll.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Program: cloud2021->PaymentService
 * @Description: PaymentService 直接写的实现类
 * @Author: 师建林
 * @Date: 2021-09-30 13:52
 * @Version： 1.0.0
 **/
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+", paymentInfo_OK ,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * @HystrixCommand  服务降级
     *                  超时设置
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        int a = 1/0;
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+", paymentInfo_TimeOut ,id:"+id+"\t"+"耗时(s)"+timeNumber+"，O(∩_∩)O哈哈~";
    }


    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+", 系统繁忙，请稍后再试 ,id:"+id+"\t"+"o(╥﹏╥)o";
    }


    //服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")  // 失败率达到多少
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0 ){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString().replaceAll("-", "");
        return Thread.currentThread().getName()+"支付调用成功,流水号："+serialNumber;
    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数,请稍后重试。o(╥﹏╥)o";
    }

}
