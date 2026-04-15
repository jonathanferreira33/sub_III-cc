package com.fiap_subiii.vehicle_service.infrastructure.messaging;

import com.fiap_subiii.vehicle_service.domain.event.PaymentApprovedEvent;
import com.fiap_subiii.vehicle_service.domain.usecase.PurchaseVehicleUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentApprovedListener {

    private final PurchaseVehicleUseCase purchaseVehicleUseCase;

    @RabbitListener(queues = "vehicle.purchase.queue")
    public void handlePaymentApproved(PaymentApprovedEvent event) {
        try {
            log.info("Processando integração de venda - Veículo ID: {}", event.vehicleId());

            if ("APPROVED".equals(event.status())) {
                purchaseVehicleUseCase.purchaseVehicle(event.vehicleId());
            }

            log.info("Veículo {} marcado como vendido com sucesso via mensageria.", event.vehicleId());
        } catch (Exception e) {
            log.error("Erro ao processar venda do veículo {}: {}", event.vehicleId(), e.getMessage());
        }
    }
}
