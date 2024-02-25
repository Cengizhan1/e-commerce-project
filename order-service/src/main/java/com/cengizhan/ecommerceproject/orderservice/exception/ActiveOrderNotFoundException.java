package com.cengizhan.ecommerceproject.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActiveOrderNotFoundException extends RuntimeException {
    public ActiveOrderNotFoundException(String s) {
        super(s);
    }
}
