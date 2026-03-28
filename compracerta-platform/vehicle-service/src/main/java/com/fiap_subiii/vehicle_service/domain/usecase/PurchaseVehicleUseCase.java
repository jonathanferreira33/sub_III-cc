package com.fiap_subiii.vehicle_service.domain.usecase;

import com.fiap_subiii.vehicle_service.domain.model.Vehicle;

import java.util.UUID;

public interface PurchaseVehicleUseCase {
    Vehicle purchaseVehicle(UUID vehicleId);
}
