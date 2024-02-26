package com.cengizhan.ecommerceproject.identityservice.repository;

import com.cengizhan.ecommerceproject.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
