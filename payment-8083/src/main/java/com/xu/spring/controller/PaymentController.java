package com.xu.spring.controller;

import com.xu.spring.service.PaymentService;
import io.micrometer.core.instrument.Meter;
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
public class PaymentController {
    @Resource
    private PaymentService service;

    @GetMapping(value = "/payment/ok")
    public String ok() {
        return service.ok();
    }

    @GetMapping(value = "/payment/timeOut")
    public String timeOut() {
        return service.timeOut();
    }

    // ***********************服务熔断***********************

    @GetMapping(value = "/payment/circuit/{id}")
    public String circuit(@PathVariable ("id") Integer id) {
        return service.circuit(id);
    }
}
