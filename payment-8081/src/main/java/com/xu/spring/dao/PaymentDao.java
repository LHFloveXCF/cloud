package com.xu.spring.dao;

import com.xu.spring.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int save(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
