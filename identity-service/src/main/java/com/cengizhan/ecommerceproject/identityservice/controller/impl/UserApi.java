package com.cengizhan.ecommerceproject.identityservice.controller.impl;


import com.cengizhan.ecommerceproject.identityservice.business.dto.UserDto;
import com.cengizhan.ecommerceproject.identityservice.business.service.IUserService;
import com.cengizhan.ecommerceproject.identityservice.data.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserApi {
        private final IUserService<UserDto, User> iUserService;


    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> userApiFindById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(iUserService.userServiceFindById(id));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> userCategoryApiUpdate(@PathVariable(name = "id") Integer id,@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.status(200).body(iUserService.userServiceUpdate(id, userDto));
    }
}
