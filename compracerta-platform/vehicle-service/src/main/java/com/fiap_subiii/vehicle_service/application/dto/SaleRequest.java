package com.fiap_subiii.vehicle_service.application.dto;


import java.util.UUID;

public record SaleRequest(
    UUID vehicleID
) { }
