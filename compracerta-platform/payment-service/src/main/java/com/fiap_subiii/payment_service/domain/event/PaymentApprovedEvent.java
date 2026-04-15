package com.fiap_subiii.payment_service.domain.event;

import java.util.UUID;

public record PaymentApprovedEvent(
        UUID vehicleId,
        UUID customerId,
        UUID paymentId,
        String status
) {
}
