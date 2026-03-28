package com.fiap_subiii.payment_service.infrastructure.messaging;

import com.fiap_subiii.payment_service.domain.event.PaymentApprovedEvent;
import com.fiap_subiii.payment_service.domain.repository.MessagePublisher;
import com.fiap_subiii.payment_service.infrastructure.configuration.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMessagePublisher implements MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishPaymentApproved(PaymentApprovedEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                event
        );
    }
}
