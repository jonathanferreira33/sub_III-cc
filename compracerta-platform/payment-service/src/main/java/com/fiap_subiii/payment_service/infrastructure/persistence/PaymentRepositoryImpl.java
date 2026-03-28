package com.fiap_subiii.payment_service.infrastructure.persistence;

import com.fiap_subiii.payment_service.domain.model.Payment;
import com.fiap_subiii.payment_service.domain.repository.PaymentRepository;
import com.fiap_subiii.payment_service.infrastructure.persistence.entity.PaymentEntity;
import com.fiap_subiii.payment_service.infrastructure.persistence.mapper.PaymentPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository jpaRepository;


    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = PaymentPersistenceMapper.toEntity(payment);
        PaymentEntity saved = jpaRepository.save(entity);
        return PaymentPersistenceMapper.toDomain(saved);
    }

    @Override
    public Payment findById(UUID id) {
        return jpaRepository.findById(id)
                .map(PaymentPersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }
}
