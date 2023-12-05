package com.cengizhan.ecommerceproject.identityservice.business.service.impl;


import com.cengizhan.ecommerceproject.identityservice.data.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cengizhan.ecommerceproject.identityservice.data.entity.Token;
import java.util.List;

public class BaseService {

    protected String getBearerToken() {
        List<Token> tokens = this.getUserDetails().getTokens();
        int size = tokens.size();
        return "Bearer " + tokens.get(size - 1).getToken();
    }

    protected Integer getUserId() {
        return this.getUserDetails().getId();
    }

    protected User getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
