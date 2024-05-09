package com.example.product.orders.model.repository;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByName(String orderRequestDtoName);
}