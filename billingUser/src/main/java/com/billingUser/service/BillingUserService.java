package com.billingUser.service;

import com.billingSys.clients.fraud.FraudClient;
import com.billingSys.clients.fraud.FraudResponse;
import com.billingSys.clients.notification.NotificationClient;
import com.billingSys.clients.notification.NotificationRequest;
import com.billingUser.domain.BillingUser;
import com.billingUser.domain.BillingUserDto;
import com.billingUser.mapper.BillingUserMap;
import com.billingUser.repository.BillingUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillingUserService {

    private final BillingUserRepository repository;
    private final BillingUserMap mapper;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void createNewUser(BillingUserDto userDto) {
        BillingUser user = BillingUser.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .build();
        repository.save(user);

        FraudResponse fraudResponse = fraudClient.checkIfFraud(user.getId());

        if(fraudResponse.getIsFraud()) {
            throw new IllegalStateException("Fraud");
        }

        notificationClient.sendNote(
                new NotificationRequest(
                        user.getId(),
                        user.getEmail(),
                        String.format("User of id %s, has been created. Welcome %s to our billing System 2000", user.getId(), user.getName())
                )
        );
    }

    public List<BillingUserDto> getAllUsers() {
        return mapper.mapToListDto(repository.findAll());
    }

    public BillingUserDto getUser(Long id) {
        return mapper.mapToDto(repository.getById(id));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
