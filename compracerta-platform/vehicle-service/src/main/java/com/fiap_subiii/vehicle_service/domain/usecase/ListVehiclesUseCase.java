package com.fiap_subiii.vehicle_service.domain.usecase;

import com.fiap_subiii.vehicle_service.domain.model.Vehicle;

import java.util.List;

public interface ListVehiclesUseCase {
    List<Vehicle> listAvailableVehicles();
    List<Vehicle> listSoldVehicles();
    List<Vehicle> listAllVehicles();
}
