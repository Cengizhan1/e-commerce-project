package com.cengizhan.ecommerceproject.identityservice.business.dto;

import com.cengizhan.ecommerceproject.identityservice.data.entity.Role;
import com.cengizhan.ecommerceproject.identityservice.data.entity.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
