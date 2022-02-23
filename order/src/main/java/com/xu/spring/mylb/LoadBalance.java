package com.xu.spring.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    ServiceInstance getInstance(List<ServiceInstance>serviceInstances);
}
