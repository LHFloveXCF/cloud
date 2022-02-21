package com.xu.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * cloud
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private int server_port;

    @GetMapping(value = "/payment/zk/get")
    public Object getObject() {
        return "hello spring cloud zookeeper" + "\t" + server_port + "\t" + UUID.randomUUID().toString();
    }
}
