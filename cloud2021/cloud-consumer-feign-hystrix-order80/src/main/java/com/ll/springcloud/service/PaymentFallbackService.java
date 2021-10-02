package com.ll.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: 师建林
 * @Date: 2021-10-01 09:42
 * @Version： 1.0.0
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService   fall back  paymentInfo_OK o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService   fall back paymentInfo_TimeOut  o(╥﹏╥)o";
    }
}
