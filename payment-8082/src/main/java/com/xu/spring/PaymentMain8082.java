package com.xu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * cloud
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8082.class, args);
    }
}
