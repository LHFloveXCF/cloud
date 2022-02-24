package com.xu.spring.service;

public interface PaymentService {
    String ok();
    String timeOut();

    /**
     * 服务熔断测试
     * @return
     */
    String circuit(Integer id);
}
