package com.cengizhan.ecommerceproject.basketservice.controller;

import com.cengizhan.ecommerceproject.basketservice.business.dto.BasketDto;
import com.cengizhan.ecommerceproject.basketservice.business.service.IBasketService;
import com.cengizhan.ecommerceproject.basketservice.data.entity.BasketEntity;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Log4j2
@RestController
//@CrossOrigin(origins = FrontendUrl.REACT_URL)
@RequestMapping("/basket-service/basket/api/v1")
public class BasketApi {

    private final IBasketService<BasketDto, BasketEntity> iBasketService;

    @GetMapping("/test")
    public String test(HttpServletRequest request) {

        String authorizationHeader = request.getHeader("Authorization");
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // "Bearer " uzunluğu kadar substring al
        }

        return token;
    }
}
