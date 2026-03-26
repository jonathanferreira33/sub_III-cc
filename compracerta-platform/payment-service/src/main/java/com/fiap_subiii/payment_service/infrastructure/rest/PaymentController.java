package com.fiap_subiii.payment_service.infrastructure.rest;

import com.fiap_subiii.payment_service.application.dto.PaymentRequest;
import com.fiap_subiii.payment_service.application.dto.PaymentResponse;
import com.fiap_subiii.payment_service.application.mapper.PaymentDTOMapper;
import com.fiap_subiii.payment_service.domain.model.Payment;
import com.fiap_subiii.payment_service.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> process(@RequestBody PaymentRequest request) {
        Payment payment = Payment.builder()
                .vehicleId(request.vehicleId())
                .customerId(request.customerId())
                .amount(request.amount())
                .build();

        Payment processed = paymentService.processPayment(payment);

        return ResponseEntity.ok(PaymentDTOMapper.toResponse(processed));
    }
}