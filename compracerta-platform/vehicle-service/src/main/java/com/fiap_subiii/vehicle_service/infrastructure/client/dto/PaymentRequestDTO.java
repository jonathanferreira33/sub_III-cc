package com.fiap_subiii.vehicle_service.infrastructure.client.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequestDTO(
        UUID vehicleId,
        UUID customerId,
        BigDecimal price
) {
}
