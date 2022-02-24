package com.xu.spring.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xu.spring.service.PaymentService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * cloud
 */
@RestController
@Slf4j
public class OrderController2 {

    @Resource
    private PaymentService2 service2;

    @GetMapping(value = "/consumer/payment/timeOut3")
    @HystrixCommand
    public String timeOut(){
        log.info("hello time out hystrix");
        return service2.paymentInfo_TimeOut();
    }
}
