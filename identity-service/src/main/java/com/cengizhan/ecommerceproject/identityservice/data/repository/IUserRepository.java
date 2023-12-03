package com.cengizhan.ecommerceproject.identityservice.data.repository;

import com.cengizhan.ecommerceproject.identityservice.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
