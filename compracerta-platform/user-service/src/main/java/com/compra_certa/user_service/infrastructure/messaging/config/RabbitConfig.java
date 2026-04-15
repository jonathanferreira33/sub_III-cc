package com.compra_certa.user_service.infrastructure.messaging.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("user.registration.queue", true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("user.exchange");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("user.registration");
    }
}
