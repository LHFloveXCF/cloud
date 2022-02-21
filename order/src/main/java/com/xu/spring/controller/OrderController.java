package com.xu.spring.controller;

import com.xu.spring.entity.CommonResult;
import com.xu.spring.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * cloud
 */
@RestController
@Slf4j
public class OrderController {

    // private static final String PAYMENT_URL = "http://localhost:8081";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;

    @GetMapping(value = "/consumer/payment/save")
    public CommonResult save(Payment payment) {
        log.info("hello world");
        return template.postForObject(PAYMENT_URL + "/payment/save/", payment, CommonResult.class);
        // return template.getForObject(PAYMENT_URL + "save/", CommonResult.class, payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult save(@PathVariable("id") Long id) {
        return template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
