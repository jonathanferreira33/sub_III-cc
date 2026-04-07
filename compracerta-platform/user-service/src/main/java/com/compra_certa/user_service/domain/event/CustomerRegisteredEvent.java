package com.compra_certa.user_service.domain.event;

public record CustomerRegisteredEvent(
        String customerId,
        String username,
        String email,
        long timestamp
) {}