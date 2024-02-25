package com.cengizhan.ecommerceproject.identityservice.business.service;

import com.cengizhan.ecommerceproject.identityservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.identityservice.business.dto.UserDto;
import com.cengizhan.ecommerceproject.identityservice.data.entity.User;
import com.cengizhan.ecommerceproject.identityservice.data.repository.IUserRepository;
import com.cengizhan.ecommerceproject.identityservice.exception.CustomException;
import com.cengizhan.ecommerceproject.identityservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Log4j2
@Service
public class UserService extends BaseService {

    private final ModelMapperBean modelMapperBean;
    private final IUserRepository iUserRepository;

    public UserDto entityToDto(User user) {
        return modelMapperBean.modelMapperMethod().map(user, UserDto.class);
    }

    public UserDto userFindById(Integer id) {
        User findUserEntity = iUserRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        return entityToDto(findUserEntity);
    }
}
