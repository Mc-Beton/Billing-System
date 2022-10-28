package com.billingUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BillingUserApp {
    public static void main(String[] args) {
        SpringApplication.run(BillingUserApp.class, args);
    }
}
