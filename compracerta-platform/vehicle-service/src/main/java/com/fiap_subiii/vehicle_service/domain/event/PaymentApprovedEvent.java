package com.fiap_subiii.vehicle_service.domain.event;

import java.io.Serializable;
import java.util.UUID;

public record PaymentApprovedEvent(
        UUID vehicleId,
        UUID paymentId,
        String status
) implements Serializable {
}
