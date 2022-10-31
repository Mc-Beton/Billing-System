package com.fraud.service;

import com.fraud.domain.FraudCheckHistory;
import com.fraud.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository repository;

    public boolean isFraudUser(Long id) {
        repository.save(
                FraudCheckHistory.builder()
                        .id(id)
                        .isFraud(false)
                        .isCreated(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}


