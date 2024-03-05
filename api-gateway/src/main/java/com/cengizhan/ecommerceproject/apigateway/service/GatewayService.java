package com.cengizhan.ecommerceproject.apigateway.service;

import com.cengizhan.ecommerceproject.apigateway.clients.IdentityServiceClient;
import org.springframework.stereotype.Service;

@Service
public class GatewayService {


    private final IdentityServiceClient identityServiceClient;

    public GatewayService(IdentityServiceClient identityServiceClient) {
        this.identityServiceClient = identityServiceClient;
    }


    public void validateToken(String authHeader) {
        try {
            identityServiceClient.validateToken(authHeader);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("invalid access...! " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


}
