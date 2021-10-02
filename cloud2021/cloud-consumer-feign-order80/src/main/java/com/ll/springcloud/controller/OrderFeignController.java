package com.ll.springcloud.controller;

import com.ll.springcloud.entities.CommonResult;
import com.ll.springcloud.entities.Payment;
import com.ll.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: cloud2021->OrderFeignController
 * @Description: OrderFeignController
 * @Author: 师建林
 * @Date: 2021-09-30 09:30
 * @Version： 1.0.0
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        //OpenFeign-ribbon,客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }

}
