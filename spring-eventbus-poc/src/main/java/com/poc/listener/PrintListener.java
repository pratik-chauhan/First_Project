package com.poc.listener;

import org.springframework.stereotype.Service;

import com.poc.doman.NotificationData;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class PrintListener implements Consumer<Event<NotificationData>> {

    

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {

        NotificationData notificationData = notificationDataEvent.getData();
        try {
            System.out.println("Print Listener : '"+notificationData.getId()+"'");
        } catch (Exception e) {
        }

    }

}
