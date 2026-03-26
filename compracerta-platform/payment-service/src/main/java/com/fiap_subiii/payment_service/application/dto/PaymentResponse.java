package com.fiap_subiii.payment_service.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponse(
        UUID id,
        UUID vehicleId,
        UUID customerId,
        BigDecimal amount,
        LocalDateTime timestamp,
        String status
) {}
