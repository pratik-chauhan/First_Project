package com.poc.listener;

import org.springframework.stereotype.Component;

import com.poc.common.GenericEvent;
import com.poc.common.GenericListener;
import com.poc.model.SMS;

@Component
public class SMSListener extends GenericListener<SMS> {

	@Override
	public void handle(GenericEvent<SMS> event) {
		System.out.println("SMS event having id :: " + event.getSource().getId());

	}

}
