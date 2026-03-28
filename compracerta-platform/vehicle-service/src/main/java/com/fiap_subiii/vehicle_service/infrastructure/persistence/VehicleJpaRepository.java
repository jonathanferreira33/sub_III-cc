package com.fiap_subiii.vehicle_service.infrastructure.persistence;

import com.fiap_subiii.vehicle_service.infrastructure.persistence.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, UUID> {

    @Modifying
    @Query("UPDATE VehicleEntity v SET v.sold = true WHERE v.id = :id AND v.sold = false")
    int updateVehicleAsSold(UUID id);

    List<VehicleEntity> findBySoldOrderByPriceAsc(boolean sold);
}