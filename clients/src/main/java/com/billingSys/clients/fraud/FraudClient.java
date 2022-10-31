package com.billingSys.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping("api/v1/fraud/{id}")
    FraudResponse checkIfFraud(@PathVariable("id") Long id);
}
