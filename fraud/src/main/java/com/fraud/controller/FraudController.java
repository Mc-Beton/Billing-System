package com.fraud.controller;

import com.billingSys.clients.fraud.FraudResponse;
import com.fraud.service.FraudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudService service;

    @GetMapping("/{id}")
    public FraudResponse checkIfFraud(@PathVariable Long id) {
        Boolean isFraud = service.isFraudUser(id);
        log.info("fraud check for user {}", id);
        return new FraudResponse(isFraud);
    }

}
