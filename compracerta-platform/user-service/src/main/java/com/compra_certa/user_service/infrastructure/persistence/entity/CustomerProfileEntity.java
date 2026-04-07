package com.compra_certa.user_service.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "customer_profiles")
@Getter
@Setter
public class CustomerProfileEntity {
    @Id
    private UUID id;

    private String email;
    private String cpf;
    private String fullName;
}
