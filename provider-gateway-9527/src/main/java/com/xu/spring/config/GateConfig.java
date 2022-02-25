package com.xu.spring.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cloud
 */
@Configuration
public class GateConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        // https://news.baidu.com
        return routeLocatorBuilder.routes().route("hello-route", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
    }
}
