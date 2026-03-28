package com.fiap_subiii.payment_service.infrastructure.persistence;

import com.fiap_subiii.payment_service.infrastructure.persistence.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
}