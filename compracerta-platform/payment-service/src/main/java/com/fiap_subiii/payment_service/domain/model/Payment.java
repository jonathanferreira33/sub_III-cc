package com.fiap_subiii.payment_service.domain.model;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Payment {
    private UUID id;
    private UUID customerId;
    private UUID vehicleId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String statusPayment;

}
