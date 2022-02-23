package com.xu.spring.mylb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * cloud
 */
@Component
public class MyLB implements LoadBalance{
    private static AtomicInteger count = new AtomicInteger(0);
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int next = increaseAndGet();
        if (serviceInstances.size() <= 0) {
            return null;
        }
        return serviceInstances.get(next % serviceInstances.size());
    }

    private final int increaseAndGet() {
        int cur;
        int next;
        do {
            cur = count.get();
            next = cur >= Integer.MAX_VALUE ? 0 : cur + 1;
        } while (!this.count.compareAndSet(cur,next));
        return next;
    }
}
