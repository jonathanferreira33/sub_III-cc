package com.compra_certa.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.compra_certa")
@EnableJpaRepositories(basePackages = "com.compra_certa.user_service.infrastructure")
@EntityScan(basePackages = "com.compra_certa.user_service.infrastructure")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
