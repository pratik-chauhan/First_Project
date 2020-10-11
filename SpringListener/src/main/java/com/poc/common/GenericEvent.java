package com.poc.common;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class GenericEvent<T> implements ResolvableTypeProvider {

	private T source;

	public GenericEvent(T source) {
		this.source = source;
	}

	@Override
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(source));
	}

	public T getSource() {
		return source;
	}

	public void setSource(T source) {
		this.source = source;
	}

}
