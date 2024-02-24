package com.cengizhan.ecommerceproject.basketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BasketItemNotFoundException extends RuntimeException {

    public BasketItemNotFoundException(String message) {
        super(message);
    }
}
