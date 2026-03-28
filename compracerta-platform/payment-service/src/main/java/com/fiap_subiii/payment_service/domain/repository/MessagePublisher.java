package com.fiap_subiii.payment_service.domain.repository;

import com.fiap_subiii.payment_service.domain.event.PaymentApprovedEvent;

public interface MessagePublisher {
    void publishPaymentApproved(PaymentApprovedEvent event);
}
