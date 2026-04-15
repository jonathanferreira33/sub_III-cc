package com.compra_certa.user_service.infrastructure.rest.dto;

public record CreateUserRequest(
        String username,
        String email,
        String password
) {
}
