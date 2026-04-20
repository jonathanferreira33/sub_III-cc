package com.compra_certa.user_service.infrastructure.persistence;

import com.compra_certa.user_service.infrastructure.persistence.entity.CustomerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserProfileRepository extends JpaRepository<CustomerProfileEntity, UUID> {
}