package com.fraud.repository;

import com.fraud.domain.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<FraudCheckHistory, Long> {
}
