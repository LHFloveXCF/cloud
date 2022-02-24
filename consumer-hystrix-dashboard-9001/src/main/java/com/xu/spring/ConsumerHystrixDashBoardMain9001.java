package com.xu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * cloud
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBoardMain9001.class, args);
    }
}
