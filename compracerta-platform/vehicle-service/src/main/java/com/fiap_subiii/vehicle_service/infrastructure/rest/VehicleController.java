package com.fiap_subiii.vehicle_service.infrastructure.rest;

import com.fiap_subiii.vehicle_service.application.dto.SaleRequest;
import com.fiap_subiii.vehicle_service.application.dto.VehicleRequest;
import com.fiap_subiii.vehicle_service.application.dto.VehicleResponse;
import com.fiap_subiii.vehicle_service.application.mapper.VehicleDTOMapper;
import com.fiap_subiii.vehicle_service.domain.model.Vehicle;
import com.fiap_subiii.vehicle_service.domain.usecase.CreateVehicleUseCase;
import com.fiap_subiii.vehicle_service.domain.usecase.ListVehiclesUseCase;
import com.fiap_subiii.vehicle_service.domain.usecase.SaleVehicleUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VehicleController {
    private final ListVehiclesUseCase listVehiclesUseCase;
    private final CreateVehicleUseCase createVehicleUseCase;
    private final SaleVehicleUseCase saleVehicleUseCase;

    public VehicleController(ListVehiclesUseCase listVehiclesUseCase,
                             CreateVehicleUseCase createVehicleUseCase, SaleVehicleUseCase saleVehicleUseCase) {
        this.listVehiclesUseCase = listVehiclesUseCase;
        this.createVehicleUseCase = createVehicleUseCase;
        this.saleVehicleUseCase = saleVehicleUseCase;
    }

    @PostMapping("/sale")
    public ResponseEntity<Void> salesRecord(
            @RequestBody SaleRequest request,
            @AuthenticationPrincipal Jwt jwt)
    {

        String keycloakUserId = jwt.getSubject();
        saleVehicleUseCase.saleVehicle(request.vehicleID(), UUID.fromString(keycloakUserId));

        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> create(
            @RequestBody VehicleRequest request,
            @AuthenticationPrincipal Jwt jwt) {

        String keycloakUserId = jwt.getSubject();

        Vehicle vehicle = Vehicle.builder()
                .id(UUID.randomUUID())
                .brand(request.brand())
                .model(request.model())
                .year(request.year())
                .color(request.color())
                .price(request.price())
                .sold(false)
                .build();

        Vehicle savedVehicle = createVehicleUseCase.createVehicle(vehicle, UUID.fromString(keycloakUserId));
        return ResponseEntity.ok(VehicleDTOMapper.toResponse(savedVehicle));
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleResponse>> listAll() {
        List<VehicleResponse> response = listVehiclesUseCase.listAllVehicles()
                .stream()
                .map(VehicleDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<VehicleResponse>> listAvailable() {
        List<VehicleResponse> response = listVehiclesUseCase.listAvailableVehicles()
                .stream()
                .map(VehicleDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sold")
    public ResponseEntity<List<VehicleResponse>> listSold() {
        List<VehicleResponse> response = listVehiclesUseCase.listSoldVehicles()
                .stream()
                .map(VehicleDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
