package com.fiap_subiii.vehicle_service.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record VehicleResponse(
        UUID id,
        String brand,
        String model,
        Integer year,
        String color,
        BigDecimal price,
        boolean sold
) {
}
