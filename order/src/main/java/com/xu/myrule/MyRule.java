package com.xu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cloud
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getMyRule() {
        return new RandomRule();
    }
}
