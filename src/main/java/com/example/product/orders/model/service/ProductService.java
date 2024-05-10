package com.example.product.orders.model.service;

import com.example.product.orders.model.domain.ProductEntity;
import com.example.product.orders.model.dto.OrderRequestDto;
import com.example.product.orders.model.dto.ProductRequestDto;
import com.example.product.orders.model.dto.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(ProductRequestDto productRequestDto);
    List<ProductResponseDto> findAllProducts();
    Optional<ProductEntity> findByName(String productName);
    void deleteProduct(ProductEntity productEntity);
}