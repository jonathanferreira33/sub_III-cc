package com.compra_certa.user_service.domain.usecase;

import java.util.UUID;

public interface CreateCustomerProfileUseCase {

    void executeCustomerProfile(UUID userId, String email) ;
}
