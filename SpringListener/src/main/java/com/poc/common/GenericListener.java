package com.poc.common;

import org.springframework.context.event.EventListener;

public abstract class GenericListener<T> {
	
	@EventListener
	public abstract void handle(GenericEvent<T> event);

}
