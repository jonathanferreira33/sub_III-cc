package com.fiap_subiii.payment_service.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Data
public class PaymentEntity {

    @Id
    private UUID id;
    private UUID vehicleId;
    private UUID customerId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String status;
}