package com.compra_certa.user_service.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer_profiles")
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

    public CustomerProfile(UUID id, String cpf, String email, String fullName, String phoneNumber, String street, String city, String zipCode, LocalDateTime createdAt) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
