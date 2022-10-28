package com.billingUser.service;

import com.billingUser.domain.BillingUser;
import com.billingUser.domain.BillingUserDto;
import com.billingUser.repository.BillingUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BillingUserService {

    private final BillingUserRepository repository;

    public void createNewUser(BillingUserDto userDto) {
        BillingUser user = BillingUser.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .build();
        repository.save(user);
    }
}
