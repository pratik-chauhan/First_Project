package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.domain.NotificationData;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Controller
public class NotificationController {

    @Autowired
    private EventBus eventBus;

    @GetMapping("/startNotification/{param}")
    public @ResponseBody String startNotification(@PathVariable Integer param) {

        for (int i = 0; i < param; i++) {

            NotificationData data = new NotificationData();
            data.setId(i);

            eventBus.notify("notificationListener", Event.wrap(data)); // publish it to listener
            eventBus.notify("printListener", Event.wrap(data)); // publish it to listener

            System.out.println("Notification " + i + ": notification task submitted successfully");
            
        }
		return "Notification started.";
    }

}
