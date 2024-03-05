package com.cengizhan.ecommerceproject.apigateway.exception;

public record ExceptionMessage (String timestamp,
                                int status,
                                String error,
                                String message,
                                String path){}