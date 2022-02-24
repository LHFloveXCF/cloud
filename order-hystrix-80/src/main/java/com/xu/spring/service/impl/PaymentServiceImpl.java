package com.xu.spring.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.xu.spring.service.PaymentService2;
import org.springframework.stereotype.Component;

/**
 * cloud
 */
@Component
@DefaultProperties
public class PaymentServiceImpl implements PaymentService2 {
    @Override
    public String paymentInfo_TimeOut() {
        return "我是消费者80，我是一个全局兜底方法2";
    }
}
