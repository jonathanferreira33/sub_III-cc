package com.compra_certa.user_service.domain.service;

import com.compra_certa.user_service.domain.model.CustomerProfile;
import com.compra_certa.user_service.domain.repository.CustomerProfileRepository;
import com.compra_certa.user_service.domain.usecase.CreateCustomerProfileUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerProfileService implements CreateCustomerProfileUseCase {

    private final CustomerProfileRepository repository;

    public CustomerProfileService(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeCustomerProfile(UUID customerId, String email) {
        if (!repository.existsById(customerId)) {
            CustomerProfile profile = new CustomerProfile();
            profile.setId(customerId);
            profile.setEmail(email);

            repository.save(profile);
        }
    }
}
