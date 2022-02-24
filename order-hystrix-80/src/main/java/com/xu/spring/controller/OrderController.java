package com.xu.spring.controller;

import com.xu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * cloud
 * 这个演示，主要是为了说明，微服务架构中有一个微服务负载过大，
 * 如果不做处理可能会导致系统中其它服务产生问题
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentService service;

    @GetMapping(value = "/consumer/payment/ok")
    public String ok() {
        return service.ok();
    }

    @GetMapping(value = "/consumer/payment/timeOut")
    public String timeOut() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return service.timeOut();
    }
}
