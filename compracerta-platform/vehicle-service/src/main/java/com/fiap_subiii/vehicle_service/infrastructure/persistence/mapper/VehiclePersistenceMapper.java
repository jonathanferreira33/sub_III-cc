package com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper;

import com.fiap_subiii.vehicle_service.domain.model.Vehicle;
import com.fiap_subiii.vehicle_service.infrastructure.persistence.entity.VehicleEntity;

public class VehiclePersistenceMapper {
    public static Vehicle toDomain(VehicleEntity entity) {
        return Vehicle.builder()
                .id(entity.getId())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .year(entity.getYear())
                .color(entity.getColor())
                .price(entity.getPrice())
                .sold(entity.isSold())
                .build();
    }

    public static VehicleEntity toEntity(Vehicle vehicle) {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(vehicle.getId());
        entity.setBrand(vehicle.getBrand());
        entity.setModel(vehicle.getModel());
        entity.setYear(vehicle.getYear());
        entity.setColor(vehicle.getColor());
        entity.setPrice(vehicle.getPrice());
        entity.setSold(vehicle.isSold());
        return entity;
    }
}
