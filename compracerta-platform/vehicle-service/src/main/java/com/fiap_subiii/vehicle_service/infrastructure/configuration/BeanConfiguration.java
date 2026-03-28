package com.fiap_subiii.vehicle_service.infrastructure.configuration;

import com.fiap_subiii.vehicle_service.domain.repository.VehicleRepository;
import com.fiap_subiii.vehicle_service.domain.service.VehicleService;
import org.springframework.context.annotation.Bean;

public class BeanConfiguration {
    @Bean
    public VehicleService vehicleService(VehicleRepository vehicleRepository) {
        return new VehicleService(vehicleRepository);
    }
}
