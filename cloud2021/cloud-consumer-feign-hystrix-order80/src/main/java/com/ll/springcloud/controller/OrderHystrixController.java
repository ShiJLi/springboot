package com.ll.springcloud.controller;

import com.ll.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Program: cloud2021->PaymentHystrixController
 * @Description:
 * @Author: 师建林
 * @Date: 2021-09-30 17:21
 * @Version： 1.0.0
 **/
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "globalFallbackMethod")   全局异常
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    public String paymentTimeOutFallbackMethod(Integer id){
        return "消费者80：支付系统繁忙，请10秒之后再试"+id+"\t"+"o(╥﹏╥)o";
    }

    /**
     * 全局异常处理
     * @return
     */
    public String globalFallbackMethod(){
        return "Global 全局异常处理，请稍后重试...o(╥﹏╥)o";
    }


}
