package com.fiap_subiii.vehicle_service.domain.repository;

import com.fiap_subiii.vehicle_service.domain.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    List<Vehicle> findAllOrderByPriceAsc(boolean sold);
    Vehicle findById(UUID id);
    List<Vehicle> findAllVehicle();
}
