package com.poc.service.impl;

import org.springframework.stereotype.Service;

import com.poc.domain.NotificationData;
import com.poc.service.NotificationService;

@Service
public class NotificationServiceimpl implements NotificationService {

    @Override
    public void initiateNotification(NotificationData notificationData) throws InterruptedException {

        System.out.println("Notification service started for Notification ID: " + notificationData.getId());

        Thread.sleep(5000); // delay added to make tasks async

        System.out.println("Notification service ended for Notification ID: " + notificationData.getId());
    }

}
