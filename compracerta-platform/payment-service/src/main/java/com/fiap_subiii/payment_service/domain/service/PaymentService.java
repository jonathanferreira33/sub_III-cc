package com.fiap_subiii.payment_service.domain.service;

import com.fiap_subiii.payment_service.domain.event.PaymentApprovedEvent;
import com.fiap_subiii.payment_service.domain.model.Payment;
import com.fiap_subiii.payment_service.domain.repository.MessagePublisher;
import com.fiap_subiii.payment_service.domain.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final MessagePublisher messagePublisher;

    public PaymentService(PaymentRepository paymentRepository, MessagePublisher messagePublisher) {
        this.paymentRepository = paymentRepository;
        this.messagePublisher = messagePublisher;
    }

    public Payment processPayment(Payment payment) {
        payment.setId(UUID.randomUUID());
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatusPayment("APPROVED");

        Payment savedPayment = paymentRepository.save(payment);

        messagePublisher.publishPaymentApproved(new PaymentApprovedEvent(
                savedPayment.getVehicleId(),
                savedPayment.getCustomerId(),
                savedPayment.getId(),
                savedPayment.getStatusPayment()
        ));

        return savedPayment;
    }
}
