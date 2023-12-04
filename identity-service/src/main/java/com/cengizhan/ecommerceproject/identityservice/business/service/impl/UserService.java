package com.cengizhan.ecommerceproject.identityservice.business.service.impl;

import com.cengizhan.ecommerceproject.identityservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.identityservice.business.dto.UserDto;
import com.cengizhan.ecommerceproject.identityservice.business.service.IUserService;
import com.cengizhan.ecommerceproject.identityservice.clients.Product;
import com.cengizhan.ecommerceproject.identityservice.clients.ProductServiceClient;
import com.cengizhan.ecommerceproject.identityservice.data.entity.Token;
import com.cengizhan.ecommerceproject.identityservice.data.entity.User;
import com.cengizhan.ecommerceproject.identityservice.data.repository.IUserRepository;
import com.cengizhan.ecommerceproject.identityservice.exception.CustomException;
import com.cengizhan.ecommerceproject.identityservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class UserService implements IUserService<UserDto, User> {

    private final ModelMapperBean modelMapperBean;
    private final IUserRepository iUserRepository;
    @Autowired
    private final ProductServiceClient productServiceClient;

    @Override
    public UserDto entityToDto(User user) {
        return modelMapperBean.modelMapperMethod().map(user, UserDto.class);
    }

    @Override
    public User dtoToEntity(UserDto userDto) {
        return modelMapperBean.modelMapperMethod().map(userDto, User.class);
    }

    @Override
    public UserDto userServiceFindById(Integer id) {
        User findUserEntity = null;
        if (id != null) {
            findUserEntity = iUserRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findUserEntity);
    }

    @Override
    public List<Product> listUserProducts() {
        return productServiceClient.getProductListByUserId(this.getUserId(), this.getBearerToken());
    }

    private String getBearerToken() {
        List<Token> tokens = this.getUserDetails().getTokens();
        int size = tokens.size();
        return "Bearer " + tokens.get(size - 1).getToken();
    }

    private Integer getUserId() {
        return this.getUserDetails().getId();
    }

    private User getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

//    @Override
//    public UserDto userServiceUpdate(Integer id, UserDto userDto) {
//        UserDto userFindDto = userServiceFindById(id);
//        if (userFindDto != null) {
//            User userEntity = dtoToEntity(userDto);
//            userEntity.setId(id);
//            userEntity.setFirstname(userDto.getFirstname());
//            userEntity.setLastname(userDto.getLastname());
//            userEntity.setEmail(userDto.getEmail());
//            iUserRepository.save(userEntity);
//        }
//        return userFindDto;
//    }
}
