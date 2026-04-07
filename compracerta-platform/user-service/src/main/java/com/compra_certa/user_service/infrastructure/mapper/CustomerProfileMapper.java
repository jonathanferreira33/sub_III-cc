package com.compra_certa.user_service.infrastructure.mapper;

import com.compra_certa.user_service.domain.model.CustomerProfile;
import com.compra_certa.user_service.infrastructure.persistence.entity.CustomerProfileEntity;

public class CustomerProfileMapper {

    public static CustomerProfileEntity toEntity(CustomerProfile domain) {
        if (domain == null) return null;
        CustomerProfileEntity entity = new CustomerProfileEntity();
        entity.setId(domain.getId());
        entity.setEmail(domain.getEmail());
        entity.setFullName(domain.getFullName());
        entity.setCpf(domain.getCpf());
        return entity;
    }

    public static CustomerProfile toDomain(CustomerProfileEntity entity) {
        if (entity == null) return null;
        return new CustomerProfile(
                entity.getId(),
                entity.getEmail(),
                entity.getFullName(),
                entity.getCpf()
        );
    }
}
