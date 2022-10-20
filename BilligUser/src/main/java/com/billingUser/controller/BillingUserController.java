package com.billingUser.controller;

import com.billingUser.domain.BillingUserDto;
import com.billingUser.service.BillingUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class BillingUserController {

    private final BillingUserService service;

    public void createNewUser(@RequestBody BillingUserDto userDto) {
        log.info("new user {}", userDto);
        service.createNewUser(userDto);
    }
}
