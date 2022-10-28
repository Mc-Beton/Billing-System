package com.billingUser.repository;

import com.billingUser.domain.BillingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BillingUserRepository extends JpaRepository<BillingUser, Long> {
}
