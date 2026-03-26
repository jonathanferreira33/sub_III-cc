package com.fiap_subiii.vehicle_service.application.mapper;

import com.fiap_subiii.vehicle_service.application.dto.VehicleResponse;
import com.fiap_subiii.vehicle_service.domain.model.Vehicle;

public class VehicleDTOMapper {

    public static VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getPrice(),
                vehicle.isSold()
        );
    }
}