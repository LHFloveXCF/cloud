package com.xu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * cloud
 */
@Configuration
public class OrderConfig {
    @Bean
    public RestTemplate getConfig() {
        return new RestTemplate();
    }
}
