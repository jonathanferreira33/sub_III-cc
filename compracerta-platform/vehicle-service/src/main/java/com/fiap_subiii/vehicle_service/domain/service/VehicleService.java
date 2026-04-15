package com.fiap_subiii.vehicle_service.domain.service;

import com.fiap_subiii.vehicle_service.domain.model.Vehicle;
import com.fiap_subiii.vehicle_service.domain.repository.VehicleRepository;
import com.fiap_subiii.vehicle_service.domain.usecase.CreateVehicleUseCase;

import com.fiap_subiii.vehicle_service.domain.usecase.ListVehiclesUseCase;
import com.fiap_subiii.vehicle_service.domain.usecase.PurchaseVehicleUseCase;
import com.fiap_subiii.vehicle_service.domain.usecase.SaleVehicleUseCase;
import com.fiap_subiii.vehicle_service.infrastructure.client.PaymentClient;
import com.fiap_subiii.vehicle_service.infrastructure.client.dto.PaymentRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService implements PurchaseVehicleUseCase, CreateVehicleUseCase, ListVehiclesUseCase, SaleVehicleUseCase {

    private final VehicleRepository vehicleRepository;
    private final PaymentClient paymentClient;

    public VehicleService(VehicleRepository vehicleRepository, PaymentClient paymentClient) {
        this.vehicleRepository = vehicleRepository;
        this.paymentClient = paymentClient;
    }

    @Override
    public List<Vehicle> listAvailableVehicles() {
        return vehicleRepository.findAllOrderByPriceAsc(false);
    }

    @Override
    public List<Vehicle> listSoldVehicles() {
        return vehicleRepository.findAllOrderByPriceAsc(true);
    }

    @Override
    public List<Vehicle> listAllVehicles() {
        return vehicleRepository.findAllVehicle();
    }

    @Override
    public Vehicle purchaseVehicle(UUID vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId);

        if (vehicle == null) {
            throw new RuntimeException("Veículo não encontrado.");
        }

        vehicle.markAsSold();

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle, UUID customerId) {

        return vehicleRepository.save(vehicle);
    }

    @Override
    public void saleVehicle(UUID vehicleId, UUID customerId) {

        var vehicle = vehicleRepository.findById(vehicleId);

        if (vehicle == null) {
            throw new RuntimeException("Veículo não encontrado.");
        }

        PaymentRequestDTO paymentRequest = new PaymentRequestDTO(
                vehicleId,
                customerId,
                vehicle.getPrice()
        );

        paymentClient.requestPayment(paymentRequest);

        vehicleRepository.save(vehicle);
    }
}
