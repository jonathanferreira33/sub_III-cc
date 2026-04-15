package com.compra_certa.user_service.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "customer_profiles")
public class CustomerProfileEntity {
    @Id
    private UUID id;

    private String email;
    private String cpf;
    private String fullName;

    public CustomerProfileEntity() {
    }

    public CustomerProfileEntity(UUID id, String email, String cpf, String fullName) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
