package com.cengizhan.ecommerceproject.identityservice.controller.impl;


import com.cengizhan.ecommerceproject.identityservice.business.dto.UserDto;
import com.cengizhan.ecommerceproject.identityservice.business.service.IUserService;
import com.cengizhan.ecommerceproject.identityservice.clients.Product;
import com.cengizhan.ecommerceproject.identityservice.data.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identity-service/api/v1/user")
@RequiredArgsConstructor
public class UserApi {
        private final IUserService<UserDto, User> iUserService;


    @GetMapping("//find/{id}")
    public ResponseEntity<?> userApiFindById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(iUserService.userServiceFindById(id));
    }

    @GetMapping("/listUserProducts")
    public ResponseEntity<List<Product>> userApiListUserProducts() {
        return ResponseEntity.ok().body(iUserService.listUserProducts());
    }

}
