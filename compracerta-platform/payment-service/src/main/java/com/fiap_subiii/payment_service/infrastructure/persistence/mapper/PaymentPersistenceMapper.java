package com.fiap_subiii.payment_service.infrastructure.persistence.mapper;

import com.fiap_subiii.payment_service.domain.model.Payment;
import com.fiap_subiii.payment_service.infrastructure.persistence.entity.PaymentEntity;

public class PaymentPersistenceMapper {

    public static Payment toDomain(PaymentEntity entity) {
        return Payment.builder()
                .id(entity.getId())
                .vehicleId(entity.getVehicleId())
                .customerId(entity.getCustomerId())
                .amount(entity.getAmount())
                .timestamp(entity.getTimestamp())
                .statusPayment(entity.getStatus())
                .build();
    }

    public static PaymentEntity toEntity(Payment payment) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setVehicleId(payment.getVehicleId());
        entity.setCustomerId(payment.getCustomerId());
        entity.setAmount(payment.getAmount());
        entity.setTimestamp(payment.getTimestamp());
        entity.setStatus(payment.getStatusPayment());
        return entity;
    }
}
