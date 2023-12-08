package com.cengizhan.ecommerceproject.basketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 400: Kötü istek
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException{

    public ResourceBadRequestException(String message) {
        super(message);
    }
}