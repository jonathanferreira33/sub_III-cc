package com.fiap_subiii.payment_service.infrastructure.configuration;

import com.fiap_subiii.payment_service.domain.repository.MessagePublisher;
import com.fiap_subiii.payment_service.domain.repository.PaymentRepository;
import com.fiap_subiii.payment_service.domain.service.PaymentService;
import org.springframework.context.annotation.Bean;

public class BeanConfiguration {
    @Bean
    public PaymentService paymentService(PaymentRepository paymentRepository, MessagePublisher messagePublisher) {
        return new PaymentService(paymentRepository, messagePublisher);
    }
}
