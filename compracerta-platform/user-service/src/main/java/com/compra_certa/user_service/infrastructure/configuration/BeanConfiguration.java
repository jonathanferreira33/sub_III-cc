package com.compra_certa.user_service.infrastructure.configuration;

import com.compra_certa.user_service.domain.repository.CustomerProfileRepository;
import com.compra_certa.user_service.domain.service.CustomerProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final CustomerProfileRepository repository;

    public BeanConfiguration(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Bean
    public CustomerProfileService customerProfileService(CustomerProfileRepository repository){
        return new CustomerProfileService(repository);
    }
}
