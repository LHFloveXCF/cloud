package com.xu.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * cloud
 */
@RestController
@Slf4j
public class OrderZkController {
    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk/get")
    public String getZk() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk/get", String.class);
    }
}
