package com.fiap_subiii.vehicle_service.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Vehicle {

    private UUID id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private BigDecimal price;
    private boolean sold;

    public void markAsSold() {
        if (this.sold) {
            throw new IllegalStateException("Veículo já foi vendido e não pode ser comercializado.");
        }
        this.sold = true;
    }
}
