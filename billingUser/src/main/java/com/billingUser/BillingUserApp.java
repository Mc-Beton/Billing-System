package com.billingUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.billingSys.clients"
)
public class BillingUserApp {
    public static void main(String[] args) {
        SpringApplication.run(BillingUserApp.class, args);
    }
}
