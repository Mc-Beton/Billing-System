package com.billingUser.mapper;

import com.billingUser.domain.BillingUser;
import com.billingUser.domain.BillingUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingUserMap {

    public BillingUserDto mapToDto(BillingUser user) {
        return new BillingUserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail()
        );
    }

    public List<BillingUserDto> mapToListDto(List<BillingUser> users) {
        return users.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
