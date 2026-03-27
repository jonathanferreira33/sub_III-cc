package com.fiap_subiii.payment_service.infrastructure.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE = "payment.exchange";
    public static final String QUEUE = "vehicle.purchase.queue";
    public static final String ROUTING_KEY = "payment.approved";

    @Bean
    public TopicExchange exchange() { return new TopicExchange(EXCHANGE); }

    @Bean
    public Queue queue() { return new Queue(QUEUE); }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
