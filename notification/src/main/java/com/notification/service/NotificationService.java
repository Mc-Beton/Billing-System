package com.notification.service;

import com.billingSys.clients.notification.NotificationRequest;
import com.notification.domain.Notification;
import com.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public void send(NotificationRequest request) {
        repository.save(
                Notification.builder()
                        .userId(request.getUserId())
                        .userMail(request.getUserName())
                        .sender("Billing System 2000")
                        .content(request.getContent())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
