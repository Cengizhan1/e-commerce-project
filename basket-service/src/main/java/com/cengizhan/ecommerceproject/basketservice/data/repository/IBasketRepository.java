package com.cengizhan.ecommerceproject.basketservice.data.repository;

import com.cengizhan.ecommerceproject.basketservice.data.entity.BasketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBasketRepository extends CrudRepository<BasketEntity, Long> {
}
