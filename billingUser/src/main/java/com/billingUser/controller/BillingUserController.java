package com.billingUser.controller;

import com.billingUser.domain.BillingUserDto;
import com.billingUser.service.BillingUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class BillingUserController {

    private final BillingUserService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewUser(@RequestBody BillingUserDto userDto) {
        log.info("new user {}", userDto);
        service.createNewUser(userDto);
    }

    @GetMapping
    public void getUsers() {
        List<BillingUserDto> users = service.getAllUsers();
        log.info("get all users list {}", users);
    }

    @GetMapping("/{id}")
    public void getUser(@PathVariable Long id) {
        BillingUserDto userDto = service.getUser(id);
        log.info("get user of id {}, {}", id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        service.deleteUser(id);
        log.info("user of id {} deleted", id);
    }
}
