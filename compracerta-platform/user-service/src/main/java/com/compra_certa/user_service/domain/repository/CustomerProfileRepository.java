package com.compra_certa.user_service.domain.repository;

import com.compra_certa.user_service.domain.model.CustomerProfile;

import java.util.Optional;
import java.util.UUID;

public interface CustomerProfileRepository {
    CustomerProfile save(CustomerProfile userProfile);
    Optional<CustomerProfile> findById(UUID id);
    boolean existsById(UUID id);
}
