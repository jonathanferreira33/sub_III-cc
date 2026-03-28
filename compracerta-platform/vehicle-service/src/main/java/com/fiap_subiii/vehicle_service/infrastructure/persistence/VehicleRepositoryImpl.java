package com.fiap_subiii.vehicle_service.infrastructure.persistence;

import com.fiap_subiii.vehicle_service.application.mapper.VehicleDTOMapper;
import com.fiap_subiii.vehicle_service.domain.model.Vehicle;
import com.fiap_subiii.vehicle_service.domain.repository.VehicleRepository;
import com.fiap_subiii.vehicle_service.infrastructure.persistence.entity.VehicleEntity;
import com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper.VehiclePersistenceMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper.VehiclePersistenceMapper.toDomain;
import static com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper.VehiclePersistenceMapper.toEntity;

public class VehicleRepositoryImpl implements VehicleRepository {

    private final VehicleJpaRepository jpaRepository;
    private final VehicleDTOMapper mapper;

    public VehicleRepositoryImpl(
            VehicleJpaRepository jpaRepository,
            VehicleDTOMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleEntity entity = toEntity(vehicle);
        VehicleEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public List<Vehicle> findAllOrderByPriceAsc(boolean sold) {
        return jpaRepository.findBySoldOrderByPriceAsc(sold)
                .stream()
                .map(VehiclePersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle findById(UUID id) {
        return jpaRepository.findById(id)
                .map(VehiclePersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

}
