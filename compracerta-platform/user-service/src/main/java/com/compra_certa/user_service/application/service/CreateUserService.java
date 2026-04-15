package com.compra_certa.user_service.application.service;

import com.compra_certa.user_service.domain.event.CustomerRegisteredEvent;
import com.compra_certa.user_service.infrastructure.client.KeycloakClient;
import com.compra_certa.user_service.infrastructure.messaging.producer.UserRegistrationProducer;
import com.compra_certa.user_service.infrastructure.service.KeycloakAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final KeycloakClient keycloakClient;
    private final KeycloakAuthService authService;
    private final UserRegistrationProducer producer;

    public void createUser(String username, String email, String password) {

        String token = authService.getAdminToken();

        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("email", email);
        user.put("enabled", true);

        Map<String, Object> credential = new HashMap<>();
        credential.put("type", "password");
        credential.put("value", password);
        credential.put("temporary", false);

        user.put("credentials", new Object[]{credential});

        keycloakClient.createUser(token, "master", user);

         //pegar o ID do Keycloak via response header
        String userId = UUID.randomUUID().toString();

        producer.send(new CustomerRegisteredEvent(
                userId,
                username,
                email,
                System.currentTimeMillis()
        ));
    }
}
