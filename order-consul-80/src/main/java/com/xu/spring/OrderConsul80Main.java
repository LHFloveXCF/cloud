package com.xu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * cloud
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul80Main.class, args);
    }
}
