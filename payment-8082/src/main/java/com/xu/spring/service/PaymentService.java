package com.xu.spring.service;

import com.xu.spring.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int save(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
