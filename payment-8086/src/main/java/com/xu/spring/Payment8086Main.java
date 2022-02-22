package com.xu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * cloud
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8086Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8086Main.class, args);
    }
}
