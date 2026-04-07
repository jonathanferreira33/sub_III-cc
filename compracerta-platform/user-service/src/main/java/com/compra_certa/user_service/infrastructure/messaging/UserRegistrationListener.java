package com.compra_certa.user_service.infrastructure.messaging;

import com.compra_certa.user_service.domain.event.CustomerRegisteredEvent;
import com.compra_certa.user_service.domain.usecase.CreateCustomerProfileUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationListener {

    private final CreateCustomerProfileUseCase createUserProfileUseCase;

    @RabbitListener(queues = "user.registration.queue")
    public void handleUserRegistration(CustomerRegisteredEvent event) {
        log.info("Novo usuário detectado no Keycloak: ID {}", event.customerId());

        createUserProfileUseCase.executeCustomerProfile(
                UUID.fromString(event.customerId()),
                event.email()
        );
    }
}
