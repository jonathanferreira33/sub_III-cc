package com.fiap_subiii.vehicle_service.infrastructure.persistence;

import com.fiap_subiii.vehicle_service.application.mapper.VehicleDTOMapper;
import com.fiap_subiii.vehicle_service.domain.model.Vehicle;
import com.fiap_subiii.vehicle_service.domain.repository.VehicleRepository;
import com.fiap_subiii.vehicle_service.infrastructure.persistence.entity.VehicleEntity;
import com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper.VehiclePersistenceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper.VehiclePersistenceMapper.toDomain;
import static com.fiap_subiii.vehicle_service.infrastructure.persistence.mapper.VehiclePersistenceMapper.toEntity;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private final VehicleJpaRepository jpaRepository;

    public VehicleRepositoryImpl(
            VehicleJpaRepository jpaRepository
    ) {
        this.jpaRepository = jpaRepository;
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
                .toList();
    }

    @Override
    public Vehicle findById(UUID id) {
        return jpaRepository.findById(id)
                .map(VehiclePersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    @Override
    public List<Vehicle> findAllVehicle() {
        return jpaRepository.findAll()
                .stream().map(VehiclePersistenceMapper::toDomain).toList();
    }

}
