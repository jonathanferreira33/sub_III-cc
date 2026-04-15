package com.fiap_subiii.vehicle_service.infrastructure.client;

import com.fiap_subiii.vehicle_service.infrastructure.client.dto.PaymentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "${payment.service.url}")
public interface PaymentClient {

    @PostMapping("/api/payments")
    void requestPayment(@RequestBody PaymentRequestDTO request);
}
