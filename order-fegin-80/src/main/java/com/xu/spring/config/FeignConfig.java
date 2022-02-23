package com.xu.spring.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cloud
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level getLevel() {
        return Logger.Level.FULL;
    }
}
