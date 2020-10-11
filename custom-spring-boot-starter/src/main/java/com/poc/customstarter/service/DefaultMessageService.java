package com.poc.customstarter.service;

public class DefaultMessageService implements MessageService {

	@Override
	public String decorateMessage(String message) {
		return "Default Message Decoration : "+message;
	}

}
