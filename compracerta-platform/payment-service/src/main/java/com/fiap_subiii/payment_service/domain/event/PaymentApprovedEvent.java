package com.fiap_subiii.payment_service.domain.event;

import java.util.UUID;

public record PaymentApprovedEvent(
        UUID vehicleId,
        UUID paymentId,
        String status
) {
}
