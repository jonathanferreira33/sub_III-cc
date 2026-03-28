package com.fiap_subiii.payment_service.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequest(
        UUID vehicleId,
        UUID customerId,
        BigDecimal amount
) {
}
