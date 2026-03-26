package com.fiap_subiii.payment_service.application.mapper;

import com.fiap_subiii.payment_service.application.dto.PaymentResponse;
import com.fiap_subiii.payment_service.domain.model.Payment;

public class PaymentDTOMapper {

    public static PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getVehicleId(),
                payment.getCustomerId(),
                payment.getAmount(),
                payment.getTimestamp(),
                payment.getStatusPayment()
        );
    }
}
