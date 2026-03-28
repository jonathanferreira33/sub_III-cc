package com.fiap_subiii.vehicle_service.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Data
public class VehicleEntity {

    @Id
    private UUID id;

    private String brand;
    private String model;
    private Integer year;
    private String color;
    private BigDecimal price;
    private boolean sold;
}
