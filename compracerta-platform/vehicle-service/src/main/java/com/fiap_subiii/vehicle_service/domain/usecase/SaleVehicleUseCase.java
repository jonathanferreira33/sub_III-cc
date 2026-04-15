package com.fiap_subiii.vehicle_service.domain.usecase;

import java.util.UUID;

public interface SaleVehicleUseCase {
    void saleVehicle(UUID vehicleId, UUID customerId);
}
