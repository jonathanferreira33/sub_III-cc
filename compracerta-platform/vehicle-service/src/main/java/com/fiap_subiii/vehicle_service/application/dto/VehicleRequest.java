package com.fiap_subiii.vehicle_service.application.dto;

import java.math.BigDecimal;

public record VehicleRequest(
        String brand,
        String model,
        Integer year,
        String color,
        BigDecimal price
) {
}
