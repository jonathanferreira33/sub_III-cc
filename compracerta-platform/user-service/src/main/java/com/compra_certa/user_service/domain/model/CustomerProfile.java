package com.compra_certa.user_service.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer_profiles")
@Getter
@Setter
@AllArgsConstructor
public class CustomerProfile {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String email;
    private String fullName;
    private String phoneNumber;
    private String street;
    private String city;
    private String zipCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public CustomerProfile() {
    }

    public CustomerProfile(UUID id, String email, String fullName, String cpf) {
        this.id = id;
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
    }
}
