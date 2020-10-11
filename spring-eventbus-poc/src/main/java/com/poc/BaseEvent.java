package com.poc;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class BaseEvent<T> implements ResolvableTypeProvider {

    private T source;

    public BaseEvent(T source) {
        this.source = source;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(source));
    }
}
