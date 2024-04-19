package com.cengizhan.ecommerceproject.identityservice.service;

import com.cengizhan.ecommerceproject.identityservice.dto.UserDto;
import com.cengizhan.ecommerceproject.identityservice.entity.User;
import com.cengizhan.ecommerceproject.identityservice.repository.IUserRepository;
import com.cengizhan.ecommerceproject.identityservice.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Log4j2
@Service
public class UserService extends BaseService {

    private final IUserRepository iUserRepository;
    
    public UserDto userFindById(Integer id) {
        User findUserEntity = iUserRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return UserDto.convert(findUserEntity);
    }
}
