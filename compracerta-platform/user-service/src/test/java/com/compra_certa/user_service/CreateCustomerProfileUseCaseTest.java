package com.compra_certa.user_service;

import com.compra_certa.user_service.domain.repository.CustomerProfileRepository;
import com.compra_certa.user_service.domain.service.CustomerProfileService;
import com.compra_certa.user_service.domain.usecase.CreateCustomerProfileUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateCustomerProfileUseCaseTest {

    @Mock
    private CustomerProfileRepository repository;

    @InjectMocks
    private CustomerProfileService useCase;

    @Test
    @DisplayName("Deve salvar um novo perfil quando o ID não existe no banco")
    void deveSalvarPerfilQuandoNaoExiste() {

        UUID customerId = UUID.randomUUID();
        String email = "teste@pos-tech.com.br";
        when(repository.existsById(customerId)).thenReturn(false);

        useCase.executeCustomerProfile(customerId, email);

        verify(repository, times(1)).save(any());
    }

    @Test
    @DisplayName("Não deve salvar perfil se o ID já estiver cadastrado")
    void naoDeveSalvarSeJaExiste() {

        UUID customerId = UUID.randomUUID();
        when(repository.existsById(customerId)).thenReturn(true);

        useCase.executeCustomerProfile(customerId, "teste@pos-tech.com.br");

        verify(repository, never()).save(any());
    }
}
