package com.xu.spring.controller;

import com.xu.spring.entity.CommonResult;
import com.xu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * cloud
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentService service;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult getOrder(@PathVariable("id") Long id) {
        return service.getPaymentById(id);
    }
    @GetMapping(value = "consumer/payment/timeOut")
    public String timeOut() {
        return service.timeOut();
    }
}
