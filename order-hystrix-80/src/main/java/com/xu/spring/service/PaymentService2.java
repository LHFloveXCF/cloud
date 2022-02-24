package com.xu.spring.service;

import com.xu.spring.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * cloud
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentServiceImpl.class)
public interface PaymentService2 {
    @GetMapping(value = "/payment/timeOut")
    String paymentInfo_TimeOut();
}
