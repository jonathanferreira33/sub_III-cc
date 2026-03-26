package com.fiap_subiii.payment_service.domain.repository;

import com.fiap_subiii.payment_service.domain.model.Payment;

import java.util.UUID;

public interface PaymentRepository {
        Payment save(Payment payment);
        Payment findById(UUID id);

}
