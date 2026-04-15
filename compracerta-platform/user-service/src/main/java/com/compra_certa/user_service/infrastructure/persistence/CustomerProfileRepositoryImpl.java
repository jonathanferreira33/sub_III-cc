package com.compra_certa.user_service.infrastructure.persistence;

import com.compra_certa.user_service.domain.model.CustomerProfile;
import com.compra_certa.user_service.domain.repository.CustomerProfileRepository;
import com.compra_certa.user_service.infrastructure.mapper.CustomerProfileMapper;
import com.compra_certa.user_service.infrastructure.persistence.entity.CustomerProfileEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerProfileRepositoryImpl implements CustomerProfileRepository {

    private final JpaUserProfileRepository jpaRepository;

    public CustomerProfileRepositoryImpl(JpaUserProfileRepository jpaRepository) {
        System.out.println(">>> Adapter carregado");
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public CustomerProfile save(CustomerProfile userProfile) {
        CustomerProfileEntity entity = new CustomerProfileEntity();
        entity.setId(userProfile.getId());
        entity.setEmail(userProfile.getEmail());

        return CustomerProfileMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<CustomerProfile> findById(UUID id) {
        return Optional.empty();
    }
}