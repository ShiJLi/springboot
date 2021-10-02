package com.ll.springcloud.service;

import com.ll.springcloud.entities.CommonResult;
import com.ll.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Program: cloud2021->PaymentFeignService
 * @Description: PaymentFeign接口
 * @Author: 师建林
 * @Date: 2021-09-30 09:20
 * @Version： 1.0.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     *
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeOut() ;
}
