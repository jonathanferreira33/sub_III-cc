package com.compra_certa.user_service.infrastructure.service;

import com.compra_certa.user_service.infrastructure.client.KeycloakClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KeycloakAuthService {

    private final KeycloakClient client;

    public String getAdminToken() {
        String body = "client_id=admin-cli" +
                "&username=admin" +
                "&password=admin" +
                "&grant_type=password";

        Map<String, Object> response = client.getToken(body);

        return "Bearer " + response.get("access_token");
    }
}
