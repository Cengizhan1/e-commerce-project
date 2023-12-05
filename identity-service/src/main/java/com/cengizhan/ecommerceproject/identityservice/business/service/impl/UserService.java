package com.cengizhan.ecommerceproject.identityservice.business.service.impl;

import com.cengizhan.ecommerceproject.identityservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.identityservice.business.dto.UserDto;
import com.cengizhan.ecommerceproject.identityservice.business.service.IUserService;
import com.cengizhan.ecommerceproject.identityservice.clients.classes.Product;
import com.cengizhan.ecommerceproject.identityservice.clients.ProductServiceClient;
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
public class UserService extends BaseService implements IUserService<UserDto, User> {

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

    @Override
    public Product showProduct(Long id) {
        return productServiceClient.getProduct(id, this.getBearerToken());
    }

    @Override
    public Product createProduct(Product product) {
        product.setUserId(this.getUserId());
        return productServiceClient.createProduct(product, this.getBearerToken());
    }

    @Override
    public Product updateProduct(Product product,Long id) {
        product.setUserId(this.getUserId());
        return productServiceClient.updateProduct(id,product, this.getBearerToken());
    }

    @Override
    public Product deleteProduct(Long id) {
        return productServiceClient.deleteProduct(id, this.getBearerToken());
    }
}
