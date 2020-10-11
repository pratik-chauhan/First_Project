package com.poc.listener;

import org.springframework.stereotype.Component;

import com.poc.common.GenericEvent;
import com.poc.common.GenericListener;
import com.poc.model.Email;

@Component
public class EmailListener extends GenericListener<Email> {

	@Override
	public void handle(GenericEvent<Email> event) {
		System.out.println("Email event having id :: " + event.getSource().getId());

	}

}
