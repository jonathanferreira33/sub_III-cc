package com.compra_certa.user_service.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "keycloak-client", url = "http://keycloak:8080")
public interface KeycloakClient {

    @PostMapping("/realms/master/protocol/openid-connect/token")
    Map<String, Object> getToken(@RequestBody String body);

    @PostMapping("/admin/realms/{realm}/users")
    void createUser(
            @RequestHeader("Authorization") String token,
            @PathVariable("realm") String realm,
            @RequestBody Map<String, Object> user
    );
}
