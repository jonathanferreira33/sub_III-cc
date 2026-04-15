package com.compra_certa.user_service.infrastructure.rest.controller;

import com.compra_certa.user_service.application.service.CreateUserService;
import com.compra_certa.user_service.infrastructure.rest.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService service;

    @PostMapping
    public void createUser(@RequestBody CreateUserRequest request) {
        service.createUser(
                request.username(),
                request.email(),
                request.password()
        );
    }
}
