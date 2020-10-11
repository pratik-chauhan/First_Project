package com.poc.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.common.GenericEvent;
import com.poc.model.Email;
import com.poc.model.SMS;

@RestController
public class Publisher {

	final ApplicationEventPublisher publisher;

	public Publisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@PostMapping("/emailEvent")
	public String emailReceiver(@RequestBody Email eventData) {
		GenericEvent<Email> event = new GenericEvent<>(eventData);
		publisher.publishEvent(event);
		return "success";
	}

	@PostMapping("/smsEvent")
	public String smsReceiver(@RequestBody SMS eventData) {
		GenericEvent<SMS> event = new GenericEvent<>(eventData);
		publisher.publishEvent(event);
		return "success";
	}

}
