package com.notification.controller;

import com.billingSys.clients.notification.NotificationRequest;
import com.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public void sendNote(@RequestBody NotificationRequest request) {
        log.info("New Note to be sent {}", request);
        service.send(request);
    }
}
