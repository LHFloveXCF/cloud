package com.xu.spring.controller;

import lombok.Value;
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
public class OrderConsulController {
    private static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate template;


    @GetMapping(value = "/consumer/payment/consul")
    public String getConsul() {
        return template.getForObject(URL + "/payment/consul", String.class);
    }
}
