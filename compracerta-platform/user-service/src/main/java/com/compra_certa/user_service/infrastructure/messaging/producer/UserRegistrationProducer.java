package com.compra_certa.user_service.infrastructure.messaging.producer;

import com.compra_certa.user_service.domain.event.CustomerRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegistrationProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(CustomerRegisteredEvent event) {
        rabbitTemplate.convertAndSend(
                "user.exchange",
                "user.registration",
                event
        );
    }
}
