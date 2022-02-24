package com.xu.spring.controller;

import com.xu.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * cloud
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService service;

    @GetMapping(value = "/payment/ok")
    public String ok() {
        return service.ok();
    }

    @GetMapping(value = "/payment/timeOut")
    public String timeOut() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return service.timeOut();
    }
}
