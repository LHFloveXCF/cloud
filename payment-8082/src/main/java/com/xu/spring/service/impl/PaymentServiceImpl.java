package com.xu.spring.service.impl;

import com.xu.spring.dao.PaymentDao;
import com.xu.spring.entity.Payment;
import com.xu.spring.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * cloud
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
