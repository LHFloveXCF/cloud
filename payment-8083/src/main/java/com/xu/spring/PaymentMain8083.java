package com.xu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * cloud
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentMain8083 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8083.class, args);
    }
}
