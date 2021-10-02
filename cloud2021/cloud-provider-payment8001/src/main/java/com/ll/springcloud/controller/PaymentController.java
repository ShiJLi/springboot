package com.ll.springcloud.controller;


import com.ll.springcloud.entities.CommonResult;
import com.ll.springcloud.entities.Payment;
import com.ll.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private Environment environment;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/payment/lb")
    public String getServerPort() {
        return environment.getProperty("local.server.port");
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,端口:" + getServerPort(), result);
        } else {
            return new CommonResult(444, "插入数据库失败,端口:" + getServerPort(), null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口:" + getServerPort(), payment);
        } else {
            return new CommonResult(444, "没有对应记录,端口:" + getServerPort() + "查询失败，id:" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(service -> log.info("********service:{}", service));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(instance -> log.info("********instance:{}", instance.getServiceId() + "\n"
                + instance.getHost() + " \n" + instance.getUri()));
        return this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return environment.getProperty("local.server.port");
    }
}
