package com.cengizhan.ecommerceproject.identityservice.controller;

import com.cengizhan.ecommerceproject.identityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final Logger logger = Logger.getLogger(UserController.class.getName());

    @GetMapping("/{id}")
    public ResponseEntity<?> userApiFindById(@PathVariable(name = "id") Integer id) {
        System.out.println("wqqwdqwdqwdq");
        return ResponseEntity.ok().body(service.userFindById(id));
    }
}
